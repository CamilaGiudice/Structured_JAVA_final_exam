package blackjackgame;
import javax.swing.*;
class Blackjackgame {

	public static void main(String[] args) {
		String viaje = "", nom, ronda2, restart; // destinos disponibles, nombre del jugador, proxima carta a sacar, restart
		int res1, ptosJ = 0, ptosC = 0; // destino elegido, puntos del jugador y del croupier
		int[] cartatiradaC = new int[2]; // array de la tirada del croupier
		int[] cartatiradaJ = new int[2]; // array de la tirada del Juegador
		int Cvc0 = 0, Cvc1 = 0, Cvc2 = 0, Jvc0 = 0, Jvc1 = 0, Jvc2 = 0; // valores especificos de las cartas
		int continuacion = 0; // blackjack directo vs prox jugada
		int adicionalJ = 0;
		int adicionalC = 0;

		do {
			// INICIO DEL JUEGO + INGRESAR NOMBRE//
			nom = (String)JOptionPane.showInputDialog(null,"¡Participa por un viaje con nuestro juego de BlackJack!\nIngresa tu nombre:","BlackJack",JOptionPane.DEFAULT_OPTION, new ImageIcon(Blackjackgame.class.getResource("/img/bienvenido.jpg")),null,null);

			// REGLAS//
			JOptionPane.showInternalMessageDialog(null,"REGLAS DEL JUEGO: \n1) Ganarle al Croupier obteniendo el puntaje más cercano a 21\n2) La J, la Q y la K valen 10 \n3) El As vale 11 o 1 \n4) Todas las otras cartas conservan su valor\n5) BLACKJACK DIRECTO: Cuando las (2) primeras cartas son 10/J/Q/K + As\n6) En la primera mano se reciben (2) cartas\n7) A partir de la segunda mano se puede pedir o no una carta","BlackJack",JOptionPane.WARNING_MESSAGE,new ImageIcon(Blackjackgame.class.getResource("/img/reglas.jpg")));

			// SWITCH - Elige el destino del viaje //
						res1 = (Integer.parseInt(JOptionPane.showInputDialog(nom + ":\nElige tu destino:\n0) Paris\n1) Bora Bora\n2) Las Vegas")));

						switch (res1) {
						case 0:
							viaje = "Paris";
							break;
						case 1:
							viaje = "Bora Bora";
							break;
						case 2:
							viaje = "Las Vegas";
							break;
						}

						while (res1 != 0 && res1 != 1 && res1 != 2) { // repite si ingresaste un valor erroneo
						res1 = Integer.parseInt(JOptionPane.showInputDialog(null,nom+":\nHubo un error en el destino elegido! Favor de volver a ingresar:\n0) Paris\n1) Bora Bora\n2) Las Vegas"));
						}

						/////////////////////////// INICIO FOR PARA COMPLETAR ARRAYS ///////////////////////////

						for (int i = 0; i < cartatiradaJ.length; i++) { // INICIO FOR - Primeras 2 tiradas del Jugador
							cartatiradaJ[i] = (int) (Math.random() * 13 + 1); // numeros random del 1 al 13, donde 1=As, 11=J, 12=Q, 13=K
						} // FIN DEL FOR
							
							// VALORES ESPECIFICOS //
							if (cartatiradaJ[0] == 1) {
								Jvc0 = 11;
							} else if (cartatiradaJ[0] == 11 || cartatiradaJ[0] == 12 || cartatiradaJ[0] == 13) {
								Jvc0 = 10;
							} else {
								Jvc0 = cartatiradaJ[0];
							}
                            ptosJ=Jvc0;
                            
							if (cartatiradaJ[1] == 1 && ptosJ < 11) {
								Jvc1 = 11;
							} else if (cartatiradaJ[1] == 1 && ptosJ >= 11) {
								Jvc1 = 1;
							} else if (cartatiradaJ[1] == 11 || cartatiradaJ[1] == 12 || cartatiradaJ[1] == 13) {
								Jvc1 = 10;
							} else {
								Jvc1 = cartatiradaJ[1];
							}
							ptosJ = ptosJ + Jvc1; // Puntos del Jugador
									

						for (int i = 0; i < cartatiradaC.length; i++) { // INICIO FOR - Primeras 2 tiradas del Croupier
							cartatiradaC[i] = (int) (Math.random() * 13 + 1); // numeros random del 1 al 13, donde 1=As, 11=J, 12=Q, 13=K
						} // FIN DEL FOR
							
							// VALORES ESPECIFICOS //
							if (cartatiradaC[0] == 1) {
								Cvc0 = 11;
							} else if (cartatiradaC[0] == 11 || cartatiradaC[0] == 12 || cartatiradaC[0] == 13) {
								Cvc0 = 10;
							} else {
								Cvc0 = cartatiradaC[0];
							}
                            ptosC=Cvc0;
                            
							if (cartatiradaC[1] == 1 && ptosC < 11) {
								Cvc1 = 11;
							} else if (cartatiradaC[1] == 1 && ptosC >= 11) {
							Cvc1 = 1;
							} else if (cartatiradaC[1] == 11 || cartatiradaC[1] == 12 || cartatiradaC[1] == 13) {
							Cvc1 = 10;
							} else {
							Cvc1 = cartatiradaC[1];
							}					
							ptosC = ptosC + Cvc1; // Puntos del Croupier					

						System.out.println("Jug: " + cartatiradaJ[0] + " & " + cartatiradaJ[1] + "||" + ptosJ + "\nCroupier: "+ cartatiradaC[0] + " & " + cartatiradaC[1] + "||" + ptosC);

						JOptionPane.showMessageDialog(null, nom + ":\nTu primera carta","BlackJack",JOptionPane.WARNING_MESSAGE,new ImageIcon(Blackjackgame.class.getResource("/img/"+cartatiradaJ[0]+".jpg")));
						JOptionPane.showMessageDialog(null, nom + ":\nTu segunda carta","BlackJack",JOptionPane.WARNING_MESSAGE,new ImageIcon(Blackjackgame.class.getResource("/img/"+cartatiradaJ[1]+".jpg")));
						JOptionPane.showMessageDialog(null, "Primera carta del Croupier","BlackJack",JOptionPane.WARNING_MESSAGE,new ImageIcon(Blackjackgame.class.getResource("/img/"+cartatiradaC[0]+".jpg")));
						JOptionPane.showMessageDialog(null, "Segunda carta del Croupier","BlackJack",JOptionPane.WARNING_MESSAGE,new ImageIcon(Blackjackgame.class.getResource("/img/"+cartatiradaC[1]+".jpg")));
						JOptionPane.showMessageDialog(null, "TABLA DE PUNTOS\nTus puntos: " + ptosJ + "\nPuntos del Croupier: " + ptosC,"BlackJack",JOptionPane.WARNING_MESSAGE,new ImageIcon(Blackjackgame.class.getResource("/img/puntaje.gif")));
						
						/////////////////////////// FIN DEL FOR PARA COMPLETAR ARRAYS ///////////////////////////

						
						/////////////////////////// DEFINO COMO CONTINUA EL JUEGO ///////////////////////////

						if (cartatiradaJ[0] == 1 && cartatiradaJ[1] == 10 || cartatiradaJ[0] == 1 && cartatiradaJ[1] == 11
								|| cartatiradaJ[0] == 1 && cartatiradaJ[1] == 12 || cartatiradaJ[0] == 1 && cartatiradaJ[1] == 13
								|| cartatiradaJ[1] == 1 && cartatiradaJ[0] == 10 || cartatiradaJ[1] == 1 && cartatiradaJ[0] == 11
								|| cartatiradaJ[1] == 1 && cartatiradaJ[0] == 12 || cartatiradaJ[1] == 1 && cartatiradaJ[0] == 13) {
							continuacion = 1; // BlackJack directo del Jugador

						} else if (cartatiradaC[0] == 1 && cartatiradaC[1] == 10 || cartatiradaC[0] == 1 && cartatiradaC[1] == 11
								|| cartatiradaC[0] == 1 && cartatiradaC[1] == 12 || cartatiradaC[0] == 1 && cartatiradaC[1] == 13
								|| cartatiradaC[1] == 1 && cartatiradaC[0] == 10 || cartatiradaC[1] == 1 && cartatiradaC[0] == 11
								|| cartatiradaC[1] == 1 && cartatiradaC[0] == 12 || cartatiradaC[1] == 1 && cartatiradaC[0] == 13) {
							continuacion = 2; // BlackJack directo del Croupier

						} else if (ptosJ == 21 && ptosJ == ptosC) {
							continuacion = 3; // EMPATE - BlackJack de ambos jugadores

						} else {
							continuacion = 0; // Próxima ronda
						}

						switch (continuacion) {
						case 0:
							JOptionPane.showMessageDialog(null,"PRÓXIMA RONDA","BlackJack",JOptionPane.WARNING_MESSAGE,new ImageIcon(Blackjackgame.class.getResource("/img/barajando.gif")));

							 do {

								for (int i = 0; i < 1; i++) { // INICIO FOR - carta adicional Croupier
									adicionalC = (int) (Math.random() * 13 + 1);
								} // FIN DEL FOR
								
									if (adicionalC== 1 && ptosC < 11) {
										Cvc2 = 11;
									} else if (adicionalC == 1 && ptosC >= 11) {
										Cvc2 = 1;
									} else if (adicionalC == 11 || adicionalC == 12 || adicionalC == 13) {
										Cvc2 = 10;
									} else {
										Cvc2 = adicionalC;
									}
									ptosC = ptosC + Cvc2;
								
								JOptionPane.showMessageDialog(null, "Carta adicional del Croupier","BlackJack",JOptionPane.WARNING_MESSAGE,new ImageIcon(Blackjackgame.class.getResource("/img/"+adicionalC+".jpg")));

								ronda2 = (String)JOptionPane.showInputDialog(null,"Tus puntos: "+ptosJ+"\nPuntos del Croupier: "+ptosC+"\n\nDesea que el Croupier le de otra carta?\nSi es (S) || No es (N)","BlackJack",JOptionPane.DEFAULT_OPTION, new ImageIcon(Blackjackgame.class.getResource("/img/cartas.jpg")),null,null);

								while (ronda2.equalsIgnoreCase("S") && ptosJ < 21 && ptosC < 21)

								{

									for (int i = 0; i < 1; i++) { // INICIO FOR - carta adicional Jugador
										adicionalJ = (int) (Math.random() * 13 + 1);
									} // FIN DEL FOR - carta adicional Jugador
									
										if (adicionalJ == 11 || adicionalJ == 12 || adicionalJ == 13) {
											Jvc2 = 10;
										} else if (adicionalJ == 1 && ptosJ < 11) {
											Jvc2 = 11;
										} else if (adicionalJ == 1 && ptosJ >= 11) {
											Jvc2 = 1;
										} else {
											Jvc2 = adicionalJ;
										}
										JOptionPane.showMessageDialog(null, nom + ":\nTu carta adicional","BlackJack",JOptionPane.WARNING_MESSAGE,new ImageIcon(Blackjackgame.class.getResource("/img/"+adicionalJ+".jpg")));
																	
									ptosJ = ptosJ + Jvc2;
									JOptionPane.showMessageDialog(null,"TABLA DE PUNTOS\nTus puntos: " + ptosJ + "\nPuntos del Croupier: " + ptosC,"BlackJack",JOptionPane.WARNING_MESSAGE,new ImageIcon(Blackjackgame.class.getResource("/img/puntaje.gif")));
									System.out.println("Tu Carta adicional es: " + adicionalJ + " || Croupier Carta adicional es: "+ adicionalC + "\n tu tot: " + ptosJ + " || tot croupier: " + ptosC);
									ronda2="N";

								}

							} while (ptosC < 21 && ptosJ < 21);

							//////////////////// FIN DEL DO /////////////////////////

							if ((ptosJ == 21 && ptosC != 21) || (ptosC > 21 && ptosJ <= 21)) {
							JOptionPane.showMessageDialog(null, nom + ":\nFELICIDADES! Has ganado con " + ptosJ + " puntos contra "+ptosC+".\nTe vas a "+viaje,"BlackJack",JOptionPane.WARNING_MESSAGE,new ImageIcon(Blackjackgame.class.getResource("/img/"+viaje+".jpg")));
							} else if ((ptosC == 21 && ptosJ != 21) || (ptosJ > 21 && ptosC <= 21)) {
							JOptionPane.showMessageDialog(null, nom + ":\nOH NO!\nHas perdido con "+ptosJ+" puntos contra "+ptosC+".\nNo te vas a "+viaje,"BlackJack",JOptionPane.WARNING_MESSAGE,new ImageIcon(Blackjackgame.class.getResource("/img/pierde.gif")));
							} else if (ptosJ == ptosC) {
							JOptionPane.showMessageDialog(null, nom + ":\nHAY EMPATE!\nObtuvieron "+ptosJ+" puntos cada uno.\nPARECE QUE EL DÍA ESTÁ LINDO, CONFORMATE CON UN PASEO POR LA PLAZA Y UN MATE","BlackJack",JOptionPane.WARNING_MESSAGE,new ImageIcon(Blackjackgame.class.getResource("/img/empate.gif")));
							} else {
							JOptionPane.showMessageDialog(null, nom + ":\nAMBOS PIERDEN!\nTus puntos: "+ptosJ+"\nPuntos del Croupier: "+ptosC,"BlackJack",JOptionPane.WARNING_MESSAGE,new ImageIcon(Blackjackgame.class.getResource("/img/pierde.gif")));
							}

							break;

						case 1:
								JOptionPane.showMessageDialog(null,"*BLACKJACK DIRECTO DEL JUGADOR*","BlackJack",JOptionPane.WARNING_MESSAGE,new ImageIcon(Blackjackgame.class.getResource("/img/blackjackdirecto.jpg")));
								JOptionPane.showMessageDialog(null,nom + ":\nHAS GANADO!\nTe vas a "+viaje,"BlackJack",JOptionPane.WARNING_MESSAGE,new ImageIcon(Blackjackgame.class.getResource("/img/"+viaje+".jpg")));
							break;

						case 2:
								JOptionPane.showMessageDialog(null,"*BLACKJACK DIRECTO DEL CROUPIER*","BlackJack",JOptionPane.WARNING_MESSAGE,new ImageIcon(Blackjackgame.class.getResource("/img/blackjackdirecto.jpg")));
								JOptionPane.showMessageDialog(null,nom + ":\nHAS PERDIDO!\nNo te vas a "+viaje,"BlackJack",JOptionPane.WARNING_MESSAGE,new ImageIcon(Blackjackgame.class.getResource("/img/pierde.gif")));						
							break;

						case 3:
							JOptionPane.showMessageDialog(null, nom + ":\nHAY EMPATE!\nAmbos obtuvieron 21 puntos.\nGanan un viaje a Mar del Plata!","BlackJack",JOptionPane.WARNING_MESSAGE,new ImageIcon(Blackjackgame.class.getResource("/img/mardel.jpg")));
							break;
						}

						restart = (String)JOptionPane.showInputDialog(null,"¿Desea jugar otra partida?\nSI->(S) || NO->(N)","BlackJack",JOptionPane.DEFAULT_OPTION, new ImageIcon(Blackjackgame.class.getResource("/img/cartas.jpg")),null,null);
					} while (restart.equalsIgnoreCase("S"));
		
		
		
		
		
				}

			

	}


