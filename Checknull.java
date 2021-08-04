public class Checknull {

    //class used to check null strings.. as we cant explicitly check for them
    public static boolean nullcheck(String a){

        if ((a != null) && (a.length() > 0)) {
            return false;
            //not null
        }
        else {
            return true;
            //null
        }
    }
}
