package agolf2;

import java.util.Hashtable;

public class Class56 {

    private Hashtable aHashtable1166 = new Hashtable();
    private Hashtable aHashtable1167 = new Hashtable();


    public void method1424(int var1, String var2) {
        this.aHashtable1166.put(Integer.valueOf(var1), var2);
    }

    public void method1425(String var1, String var2) {
        this.aHashtable1167.put(var1, var2);
    }

    public String method1426(int var1) {
        return (String) this.aHashtable1166.get(Integer.valueOf(var1));
    }

    public String method1427(String var1) {
        return (String) this.aHashtable1167.get(var1);
    }

    public void method1428() {
        this.aHashtable1166.clear();
        this.aHashtable1167.clear();
    }
}
