package agolf2;

import com.aapeli.colorgui.ColorList;
import com.aapeli.colorgui.MultiColorList;

import java.util.Enumeration;
import java.util.Hashtable;

class Class42 {

    private Class58_Sub1 aClass58_Sub1_1079;
    private Hashtable aHashtable1080;


    protected Class42(Class58_Sub1 var1) {
        this.aClass58_Sub1_1079 = var1;
        this.aHashtable1080 = new Hashtable();
    }

    protected void clear() {
        this.aHashtable1080.clear();
    }

    protected void add(EditorListState var1) {
        this.aHashtable1080.put(var1.method1288(), var1);
    }

    protected void method1295(MultiColorList var1) {
        Enumeration var2 = this.aHashtable1080.elements();

        while (var2.hasMoreElements()) {
            ((EditorListState) var2.nextElement()).method1289(this.aClass58_Sub1_1079, var1);
        }

    }

    protected void method1296(ColorList var1) {
        Enumeration var2 = this.aHashtable1080.elements();

        while (var2.hasMoreElements()) {
            ((EditorListState) var2.nextElement()).method1290(var1);
        }

    }
}
