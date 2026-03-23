public class ExercitiuVectori {
    static void afisare(String mesaj, int[] vector) {
        System.out.print(mesaj+":");
        for(int numar:vector) {
            System.out.print(numar + " ");
        }
        System.out.println();
    }
    static int[] adaugareInceput(int[] vector, int numar) {
        //asta e entry pointul pt proiect ca sa poata fi rulat individual

        int[] vectorNou=new int[vector.length+1];
       //var vectorNou = new int[vector.length+1];
        vectorNou[0]=numar;
        for(int i=0;i< vector.length;i++) {
            vectorNou[i+1]=vector[i];
        }
        //System.arraycopy(vector,0,vectorNou,1,vector.length);
        return vectorNou;
    }

     public static void main(String[] args) {
        String[] valoriString=args[0].split(",");
        // args[0] = "1,2,3,4" ceva de genul, args[0] este ce se scrie in consola, primul argument primit de program
         int[] valoriInt= new int[valoriString.length];
         for(int i=0;i< valoriInt.length;i++) {
             valoriInt[i]=Integer.parseInt(valoriString[i].trim());
         }
         afisare("Vector",valoriInt);
         valoriInt=adaugareInceput(valoriInt,67);
         afisare("Vector nou",valoriInt);
     }
}
