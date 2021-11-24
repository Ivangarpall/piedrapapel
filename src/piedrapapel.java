import java.util.Scanner;

public class piedrapapel {

    public enum Jugada {
        PIEDRA,
        PAPEL,
        TIJERA
    }
    public enum Resultado{
        GANA_JUGADOR,
        GANA_AI,
        EMPATE
    }

        public static Jugada jugadaAI() {
            int jugada = (int) (Math.random() * 3);

            Jugada[] elccion = new Jugada[]{Jugada.PIEDRA, Jugada.PAPEL, Jugada.TIJERA};


            return elccion[jugada];

        }

        public static Resultado calculaGanador(Jugada jugadaUsuario, Jugada jugadaAI) {

            if (jugadaUsuario==Jugada.PIEDRA && jugadaAI==Jugada.PIEDRA) {
                return Resultado.EMPATE;
            }
            else if(jugadaUsuario==Jugada.PIEDRA && jugadaAI==Jugada.PAPEL){
               return Resultado.GANA_AI;
            }
            else if (jugadaUsuario==Jugada.PIEDRA &&jugadaAI==Jugada.TIJERA){
               return Resultado.GANA_JUGADOR;
            }
            else if (jugadaUsuario==Jugada.PAPEL&&jugadaAI==Jugada.PAPEL){
                return Resultado.EMPATE;
            }
            else if (jugadaUsuario==Jugada.PAPEL&&jugadaAI==Jugada.TIJERA){
                return Resultado.GANA_AI;
            }
            else if (jugadaUsuario==Jugada.PAPEL&&jugadaAI==Jugada.PIEDRA){
                return Resultado.GANA_JUGADOR;
            }
            else if (jugadaUsuario==Jugada.TIJERA&&jugadaAI==Jugada.TIJERA){
                return Resultado.EMPATE;
            }
            else if (jugadaUsuario==Jugada.TIJERA&&jugadaAI==Jugada.PIEDRA){
                return Resultado.GANA_AI;
            }
            else {return Resultado.GANA_JUGADOR;}



        }
        public static void muestraEstadisticas(Jugada[]jugadas){
            int pi=0;
            int pa=0;
            int ti=0;
            for (int i=0;i<jugadas.length;i++){
                if (jugadas[i] == Jugada.PIEDRA){
                    pi++;
                }
                else if (jugadas[i]== Jugada.PAPEL){
                    pa++;
                }
                else{ ti++;}
            }
            System.out.println("el porcentaje de piedras es:"+(((float)pi/10)*100)+"%");
            System.out.println("el porcentaje de papel es: "+(((float)pa/10)*100)+"%");
            System.out.println("el porcentaje de tijeras es: "+(((float)ti/10)*100)+"%");
            int u=0;
            int AI=0;
            int em=0;

            for (int i=0;i<jugadas.length;i+=2){
                if (calculaGanador(jugadas[i],jugadas[i+1])== Resultado.GANA_JUGADOR){
                    u++;
                }
                else if(calculaGanador(jugadas[i],jugadas[i+1])== Resultado.GANA_AI) {
                    AI++;
                }
                else {em++;}
            }
            System.out.println("el porcentaje de victorias del usuario es:"+(((float)u/5)*100)+"%");
            System.out.println("el porcentaje de victorias de la AI es:"+(((float)AI/5)*100)+"%");
            System.out.println("el porcentaje de empates es:"+(((float)em/5)*100)+"%");
        }

        public static void main(String[] args) {
            Scanner reader= new Scanner(System.in);
            Jugada[] plays= new Jugada[10];
            for (int i=0;i< plays.length;i+=2){
                plays[i]=Jugada.valueOf(reader.next().toUpperCase());
                plays[i+1]= jugadaAI();
            }

            muestraEstadisticas(plays);


        }


    }


