package agolf2;


class Class49 {

    private String aString1139;
    private boolean aBoolean1140;


    protected Class49(String var1) {
        int var2 = var1.indexOf('.');
        if (var2 == -1) {
            this.aString1139 = var1;
            this.aBoolean1140 = false;
        } else {
            this.aString1139 = var1.substring(0, var2);
            this.aBoolean1140 = var1.substring(var2 + 1).equals("t");
        }

    }

    protected String method1379() {
        return this.aString1139;
    }

    protected boolean method1380() {
        return this.aBoolean1140;
    }
}
