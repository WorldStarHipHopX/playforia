/*
 * Created by JFormDesigner on Sat Jul 06 22:54:10 CEST 2013
 */

package org.moparforia.editor;

import org.moparforia.shared.Track;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Johan Ljungberg
 * @author fc
 */
public class TrackEditor extends JFrame implements IEditor {

    private SpriteManager spriteManager;
    private MapCanvas mapCanvas;

    private JLabel backSelection;
    private JLabel foreSelection;

    public TrackEditor() {
        initComponents();
    }

    public static void main(String[] args) {
        TrackEditor n = new TrackEditor("lol");
        n.setVisible(true);
    }

    public TrackEditor(String s) {
        initComponents();
        this.setSize(941, 645);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        spriteManager = new SpriteManager(this);
        Map m = new Map();
        mapCanvas = new MapCanvas(this);
        mapCanvas.setSpriteManager(spriteManager);
        trackCanvas.setBackground(Color.BLACK);
        trackCanvas.add(mapCanvas);
        mapCanvas.setMap(m);
        generateButtons();
        backSelection = new JLabel();
        foreSelection = new JLabel();

        JPanel selection = new JPanel();
        selection.setPreferredSize(new Dimension(80, 80));
        selection.setLayout(new GridLayout(2, 1, 5, 5));
        TitledBorder tb = new TitledBorder("Selected");
        selection.setBorder(tb);

        selection.add(backSelection);
        selection.add(foreSelection);
        canvasPanel.add(selection, BorderLayout.EAST);

        Image[][] sprites = mapCanvas.getSpriteSet();
        backSelection.setIcon(new ImageIcon(sprites[1][0]));
        foreSelection.setIcon(new ImageIcon(sprites[1][0]));
    }

    public MapCanvas getMapCanvas() {
        return mapCanvas;
    }

    private void generateButtonGroup(final int groupIndex) {
        Image[][] sprites = mapCanvas.getSpriteSet();
        final ButtonGroup group = new ButtonGroup();
        final JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        for (int i = 0; i < sprites[groupIndex].length; i++) {
            JButton button = new JButton();
            final ImageIcon icon = new ImageIcon(sprites[groupIndex][i]);
            button.setIcon(icon);
            button.setPreferredSize(new Dimension(24, 24));
            group.add(button);
            final int index = i;

            button.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Tile oldTile = mapCanvas.getSelectedTile();
                    Tile newTile;

                    if (oldTile != null) {
                        newTile = oldTile.clone();
                    } else {
                        newTile = new Tile();
                    }

                    switch (groupIndex) {
                        case 0:
                            newTile.setSpecial(false);
                            newTile.setShapeIndex(index);
                            break;
                        case 1:

                            if (SwingUtilities.isLeftMouseButton(e)) {
                                newTile.setBackground(index);
                                backSelection.setIcon(icon);
                            } else {
                                newTile.setForeground(index);
                                foreSelection.setIcon(icon);
                            }

                            break;
                        case 2:
                            newTile.setSpecial(true);
                            newTile.setShapeIndex(index);
                            foreSelection.setIcon(icon);
                            break;
                        default:
                            break;
                    }
                    mapCanvas.setSelectedTile(newTile);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }
            });


            panel.add(button);
        }
        if (groupIndex == 0) {
            maskPanel.add(panel);
        } else if (groupIndex == 1) {
            canvasPanel.add(panel, BorderLayout.NORTH);
        } else {
            maskPanel.add(panel);
        }
    }

    public int getDrawMode() {
        if (togglePencil.isSelected()) {
            return 0;
        } else if (toggleRectangle.isSelected()) {
            return 1;
        } else if (toggleCircle.isSelected()) {
            return 2;
        } else if (toggleFill.isSelected()) {
            return 3;
        }
        return 0;
    }

    private void generateButtons() {
        for (int i = 0; i < 3; i++) {
            generateButtonGroup(i);
        }

        ButtonGroup group = new ButtonGroup();
        group.add(togglePencil);
        group.add(toggleFill);
        group.add(toggleCircle);
        group.add(toggleRectangle);
        togglePencil.setSelected(true);
    }

    public static final Track loadTrack(File f) throws IOException {

        String name = null, author = null, data = null;
        Scanner scanner = new Scanner(new FileInputStream(f));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.startsWith("V ")) {
                // hi
            } else if (line.startsWith("S ")) {
                // hi? get on it, watson
            } else if (line.startsWith("A ")) {
                author = line.substring(2);
            } else if (line.startsWith("N ")) {
                name = line.substring(2);
            } else if (line.startsWith("T ")) {
                data = line.substring(2);
            }
        }
        return new Track(name, author, data, 7);
    }

    private void menuNewActionPerformed(ActionEvent e) {
        mapCanvas.setMap(new Map());
    }

    private void menuOpenActionPerformed(ActionEvent e) {
        try {
            JFileChooser chooser = new JFileChooser("tracks/custom/");
            int result = chooser.showOpenDialog(this);
            if (result != JFileChooser.CANCEL_OPTION) {
                File f = chooser.getSelectedFile();
                Track currentTrack = loadTrack(f);
                Map m = new MapDecompressor().decompress(currentTrack.getMap());
                mapCanvas.updateProperties(currentTrack.getName(), currentTrack.getCategory());
                mapCanvas.setMap(m);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
            JOptionPane.showMessageDialog(this, "Invalid or corrupt track!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void menuSaveActionPerformed(ActionEvent e) {

        if (!isValidTrack(mapCanvas.getMap())) {
            JOptionPane.showMessageDialog(this, "The current track is impassable, please ensure there is a starting position, finishing hole and a valid path between.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (mapCanvas.getTrackName().equals("") || mapCanvas.getTrackCategory() == 0) {
            JOptionPane.showMessageDialog(this, "You need to specify a Track Name and/or Category before saving!", "Error", JOptionPane.ERROR_MESSAGE);
            new TrackPropertiesDialog(this).setVisible(true);
            menuSaveActionPerformed(e);
            return;
        }
        String data = new MapCompressor().compress(mapCanvas.getMap());
        Track t = new Track(mapCanvas.getTrackName(), "editor", data, 7);

        JFileChooser saver = new JFileChooser("tracks/custom/");
        saver.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.getName().endsWith(".track");
            }

            @Override
            public String getDescription() {
                return "*.track";
            }
        });
        saver.setSelectedFile(new File(t.getName().replaceAll(" ", "_")));
        int result = saver.showSaveDialog(this);

        if (result == JFileChooser.CANCEL_OPTION) return;

        t.setMap(data);
        String save = t.toSaveString().replace("\t", "\n");

        PrintStream out = null;
        try {
            out = new PrintStream(new FileOutputStream(saver.getSelectedFile(), false));
            out.print(save);
        } catch (Exception ee) {
            JOptionPane.showMessageDialog(this, "Failed to save track!", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (out != null) out.close();
        }
    }

    public static boolean isValidTrack(Map m) {
        Tile[][] tiles = m.toTileArray();
        boolean containsHole = false;
        ArrayList<Integer> startX = new ArrayList<Integer>();
        ArrayList<Integer> startY = new ArrayList<Integer>();

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                Tile t = tiles[i][j];
                if (t.isStartPosition()) {
                    startX.add(i);
                    startY.add(j);
                }
                if (t.isHole()) {
                    containsHole = true;
                }
            }
        }
        if (!containsHole || (startX.isEmpty() && startY.isEmpty())) {
            return false; // if there is no hole or starting positions, ITS NOT VALID!
        }
        for(int i = 0; i < startX.size(); i++) {
            System.out.println(startX.get(i)+" "+startY.get(i));
        boolean[][] visited = new boolean[tiles.length][tiles[0].length];
            if(!traverseTrack(m, visited, startX.get(i), startY.get(i))) {
                return false; // if any starting positions don't work, then bye bye.
            }
        }
        return true; // only da true heroes make it this far!
    }

    public static boolean traverseTrack(Map m, boolean[][] visited, int x, int y) {
        if (m.getTile(x, y).isHole()) {
            return true;
        }
        visited[x][y] = true;
        if (!m.getTile(x, y).isPassable()) {
            return false;
        }

        if (x + 1 < 49 && !visited[x + 1][y])
            if (traverseTrack(m, visited, x + 1, y)) {
                return true;
            }
        if (x - 1 >= 0 && !visited[x - 1][y])
            if (traverseTrack(m, visited, x - 1, y)) {
                return true;
            }
        if (y + 1 < 25 && !visited[x][y + 1])
            if (traverseTrack(m, visited, x, y + 1)) {
                return true;
            }
        if (y - 1 >= 0 && !visited[x][y - 1])
            if (traverseTrack(m, visited, x, y - 1)) {
                return true;
            }

        return false;
    }

    private void menuQuitActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    private void menuPreferencesActionPerformed(ActionEvent e) {
        new TrackPropertiesDialog(this).setVisible(true);
    }

    private void menuGridActionPerformed(ActionEvent e) {
        mapCanvas.toggleGrid();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar = new JMenuBar();
        menuFile = new JMenu();
        menuNew = new JMenuItem();
        menuOpen = new JMenuItem();
        menuSave = new JMenuItem();
        menuQuit = new JMenuItem();
        menuTrack = new JMenu();
        menuPreferences = new JMenuItem();
        menuView = new JMenu();
        menuGrid = new JCheckBoxMenuItem();
        trackCanvas = new JPanel();
        canvasPanel = new JPanel();
        maskPanel = new JToolBar();
        togglePencil = new JToggleButton();
        toggleRectangle = new JToggleButton();
        toggleCircle = new JToggleButton();
        toggleFill = new JToggleButton();


        //======== this ========
        setTitle("Playforia Minigolf Track Editor (BETA)");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar ========
        {

            //======== menuFile ========
            {
                menuFile.setText("File");

                //---- menuNew ----
                menuNew.setText("New");
                menuNew.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuNewActionPerformed(e);
                    }
                });
                menuFile.add(menuNew);
                menuFile.addSeparator();

                //---- menuOpen ----
                menuOpen.setText("Open");
                menuOpen.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuOpenActionPerformed(e);
                    }
                });
                menuFile.add(menuOpen);

                //---- menuSave ----
                menuSave.setText("Save");
                menuSave.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuSaveActionPerformed(e);
                    }
                });
                menuFile.add(menuSave);
                menuFile.addSeparator();

                //---- menuQuit ----
                menuQuit.setText("Quit");
                menuQuit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuQuitActionPerformed(e);
                    }
                });
                menuFile.add(menuQuit);
            }
            menuBar.add(menuFile);

            //======== menuTrack ========
            {
                menuTrack.setText("Track");

                //---- menuPreferences ----
                menuPreferences.setText("Preferences");
                menuPreferences.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuPreferencesActionPerformed(e);
                    }
                });
                menuTrack.add(menuPreferences);
            }
            menuBar.add(menuTrack);

            //======== menuView ========
            {
                menuView.setText("View");

                //---- menuGrid ----
                menuGrid.setText("Grid");
                menuGrid.setSelected(true);
                menuGrid.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuGridActionPerformed(e);
                    }
                });
                menuView.add(menuGrid);
            }
            menuBar.add(menuView);
        }
        setJMenuBar(menuBar);

        //======== trackCanvas ========
        {
            trackCanvas.setPreferredSize(new Dimension(735, 375));
            trackCanvas.setLayout(null);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < trackCanvas.getComponentCount(); i++) {
                    Rectangle bounds = trackCanvas.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = trackCanvas.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                trackCanvas.setMinimumSize(preferredSize);
                trackCanvas.setPreferredSize(preferredSize);

            }
        }
        contentPane.add(trackCanvas, BorderLayout.CENTER);

        //======== canvasPanel ========
        {
            canvasPanel.setBorder(new TitledBorder("Palette"));
            canvasPanel.setLayout(new BorderLayout());
        }
        contentPane.add(canvasPanel, BorderLayout.SOUTH);

        //======== maskPanel ========
        {
            maskPanel.setFloatable(false);
            maskPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 1));
            maskPanel.setPreferredSize(new Dimension(16, 80));

            //---- togglePencil ----
            togglePencil.setIcon(new ImageIcon(getClass().getResource("/pencil_icon&16.png")));
            maskPanel.add(togglePencil);

            //---- toggleRectangle ----
            toggleRectangle.setIcon(new ImageIcon(getClass().getResource("/playback_stop_icon&16.png")));
            maskPanel.add(toggleRectangle);

            //---- toggleCircle ----
            toggleCircle.setIcon(new ImageIcon(getClass().getResource("/playback_rec_icon&16.png")));
            toggleCircle.setEnabled(false);
            maskPanel.add(toggleCircle);

            //---- toggleFill ----
            toggleFill.setIcon(new ImageIcon(getClass().getResource("/fill_icon&16.png")));
            toggleFill.setEnabled(false);
            maskPanel.add(toggleFill, BorderLayout.NORTH);
        }
        contentPane.add(maskPanel, BorderLayout.NORTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenuItem menuNew;
    private JMenuItem menuOpen;
    private JMenuItem menuSave;
    private JMenuItem menuQuit;
    private JMenu menuTrack;
    private JMenuItem menuPreferences;
    private JMenu menuView;
    private JCheckBoxMenuItem menuGrid;
    private JPanel trackCanvas;
    private JPanel canvasPanel;
    private JToolBar maskPanel;
    private JToggleButton togglePencil;
    private JToggleButton toggleRectangle;
    private JToggleButton toggleCircle;
    private JToggleButton toggleFill;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
