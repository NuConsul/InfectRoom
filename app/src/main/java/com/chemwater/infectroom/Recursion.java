package com.chemwater.infectroom ;

public class Recursion {


    static public class Building {

        public final boolean isInfected;
        public boolean visited = false;

        Building (boolean infected) {
            isInfected = infected;
        }

    }


    private static int returnSize(Building[][] cells, int horiz, int verti) {
        if (horiz < 0 || verti < 0 || horiz > cells.length || verti >= cells[horiz].length) {
            return 0 ;
        }

        if (!cells[horiz][verti].isInfected || cells[horiz][verti].visited) {
            return 0 ;
        }


        cells[horiz][verti].visited = true ;
        int size = 1 ;
        for(int i = horiz - 1 ; i <= horiz + 1 ; i++) {

            for (int c = verti - 1 ;  c <= verti + 1 ; c++) {
                if(i == horiz || c == verti) {
                    size += returnSize(cells, i, c) ;
                }
            }
        }

        return size ;
    }





    public static boolean isOutbreak(Building[][] floor) {

        for(int horiz = 0 ; horiz < floor.length ; horiz++) {
            for (int verti = 0 ; verti < floor[horiz].length ; verti++) {

                if(floor[horiz][verti].isInfected && !floor[horiz][verti].visited) {

                    int size = returnSize(floor, horiz, verti) ;

                    if(size >= 5)
                        return true ;
                }
            }
        }
        return false ;
    }


    public static void main(String[] args) {


        Building[][] verticalTrue = new Building[][] {
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false) },
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false) },
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false) },
                {new Building(false), new Building(true),  new Building(false), new Building(true),  new Building(true),  new Building(false), new Building(false), new Building(false), new Building(false) },
                {new Building(false), new Building(true),  new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false) },
                {new Building(false), new Building(true),  new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false) },
                {new Building(false), new Building(true),  new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false) },
                {new Building(false), new Building(true),  new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false) },
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false) },
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false) }
        };


        Building[][] horizontalTrue = new Building[][] {
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false) },
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false) },
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false) },
                {new Building(false), new Building(true),  new Building(true),  new Building(true),  new Building(true),  new Building(true),  new Building(false), new Building(false), new Building(false) },
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false) },
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false) },
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false) },
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false) },
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false) },
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false) }
        } ;



        Building[][] noInfection = new Building[][] {
                {new Building(true),  new Building(false), new Building(true),  new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false) },
                {new Building(false), new Building(true),  new Building(false), new Building(true),  new Building(false), new Building(false), new Building(false), new Building(false), new Building(false) },
                {new Building(true),  new Building(false), new Building(true),  new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false) },
                {new Building(false), new Building(true),  new Building(false), new Building(true),  new Building(false), new Building(true),  new Building(false), new Building(false), new Building(false) },
                {new Building(false), new Building(true),  new Building(false), new Building(false), new Building(true),  new Building(false), new Building(false), new Building(false), new Building(false) },
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(true),  new Building(false), new Building(false), new Building(false) },
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(true),  new Building(false), new Building(false) },
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false) },
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false) },
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false) }
        };




        System.out.println("Horizontal = " + isOutbreak(verticalTrue)) ;
        System.out.println("Vertical = " + isOutbreak(horizontalTrue)) ;
        System.out.println("No Outbreak = " + isOutbreak(noInfection)) ;
    }


}
