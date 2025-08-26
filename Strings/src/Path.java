public class Path {
    public static double shortestPath(String str){
        int x = 0, y=0;
        for (int i = 0; i <str.length() ; i++) {
            char dir = str.charAt(i);
            if (dir == 'S'){
                y--;
            } else if (dir=='N') {
                y++;
            } else if (dir=='W') {
                x--;
            }
            else{
                x++;
            }
        }
        int X2 = (int) Math.pow(x, 2);
        int Y2 = (int) Math.pow(y, 2);

        return Math.sqrt(X2+Y2);
    }


    public static void main(String[] args) {
        System.out.println(shortestPath("WNEENESENNN"));
    }
}
