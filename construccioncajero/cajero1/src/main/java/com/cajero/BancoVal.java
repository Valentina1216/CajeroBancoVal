package com.cajero;

import java.util.Scanner;

public class BancoVal {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

    // Variables constantes
        final int PIN_CORRECTO = 1234;
        double saldo = 100000000;
        int intentos = 0;
        boolean cuentaBloqueada = false;

    // autenticacion segun los intentos
        while (intentos < 3) {
            System.out.println("ingresa tu PIN: ");
            int pinIngresado = scanner.nextInt();

            if (pinIngresado == PIN_CORRECTO) {
                System.out.println("Bienvenido al Banco Val");
                break;
            } else {
                intentos ++;
                System.out.println("Ay noooo, tu PIN no funciona :c, intenta una vez más)" + intentos);
            }
            if (intentos == 3) {
                cuentaBloqueada = true;
                System.out.println("¿Para que te metes si no es tuyo? bloqueado.");
            }
        }

    //si la cuenta está bloqueada, finalizará el programa

            if(cuentaBloqueada) {
                scanner.close();
                return;
            }

    //menú de cajero
            int opcion;
            do {
                System.out.println("Bienvenido a Banco Val");
                System.out.println("1. Consultar tu saldo");
                System.out.println("2. Retirar tu saldo");
                System.out.println("3. Depositar tu dinero");
                System.out.println("4. Enviar dinero");
                System.out.println("5. Guardar dinero en 'Alcancia'");
                System.out.println("6. Salir del banco Val");
                System.out.println("Selecciona lo que necesites");
                opcion = scanner.nextInt();

    //Manejo de opciones
            switch (opcion) {
                case 1:
                    System.out.println("Ay noooo, apenas tienes: " + saldo);
                    break;
                    
                case 2:
                    System.out.println("¿Cuanto dinero vas a sacar?: ");
                    double retiro = scanner.nextDouble();
                    if(retiro > 0 && retiro <= saldo) {
                        saldo -= retiro;
                        System.out.println("retiro exitoso!!, te quedan apenas: " + saldo);
                    } else  {
                        System.out.println("No se puede  sacar tantoooo: " + saldo);
                    }
                    break;
                    
                case 3:
                    System.out.println("¿cuanto vas a consignar?:3 : ");
                    double deposito = scanner.nextDouble();
                    if (deposito > 0) {
                        saldo += deposito;
                        System.out.println("Consignacion exitosa, su nuevo saldo es: " + saldo);
                    } else {
                        System.out.println("Nopi, no tienes ese saldo");
                    }
                    break;

                    
                case 4:
                    System.out.println("¿A que cuenta la vas a enviar?: ");
                    int cuenta = scanner.nextInt();
                    System.out.println("¿Cuanto quieres enviar?: ");
                    double enviar = scanner.nextDouble();
                    if(enviar > 0 && enviar <= saldo) {
                        saldo -= enviar;
                        System.out.println("Envio exitoso!!, te quedan apenas: " + saldo);
                    } else  {
                        System.out.println("No puedes enviarlo en este momento, tu saldo es: " + saldo);
                    }
                    break; 

                case 5: 
                    System.out.println("¿Cuanto quieres guardar en 'Alcancia'?: ");
                    double alcancia = scanner.nextDouble();
                    if(alcancia > 0 && alcancia <= saldo) {
                    saldo -= alcancia;
                    System.out.println("Listoo, en tu Alcancia hay: " + alcancia);
                    System.out.println("Y en tu Cuenta de ahorros quedan: " + saldo);
                    } else  {
                    System.out.println("No puedes guardar en la opcion 'Alcancia' :( ");
                    }
                    break; 
                    
                case 6:
                    System.out.println("Nos vemos :3"); 
                    break;

                default:
                System.out.println("esa no es una opcion :/ ");
                    break;

            }

                } while (opcion !=6);
        scanner.close();

    }

}