//package principal;

public class neurona {
	private int[] pesos;
	private int threshold;
	
	
	public neurona(int[]pesos, int threshold) {
		
		this.pesos = pesos.clone();
		this.threshold = threshold;
		

	}

	public int calcularSalida(int[] entradas) {
		int suma = 0;
		for(int i = 0; i < entradas.length; i++) {
			suma += entradas[i] * pesos [i];
		}
		
		if (suma >= threshold) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		
		neurona and = new neurona(new int[] {1,1},2);
		int salida = and.calcularSalida(new int[] {1,1});
		System.out.println("\nCompuerta 'AND':");

		System.out.println(and.calcularSalida(new int[] {0, 0}));
		System.out.println(and.calcularSalida(new int[] {0, 1}));
		System.out.println(and.calcularSalida(new int[] {1, 0}));
		System.out.println(and.calcularSalida(new int[] {1, 1}));
		
		System.out.println("\nCompuerta 'OR':");
		
		neurona or = new neurona(new int[] {1,1},1);

		System.out.println(or.calcularSalida(new int[] {0, 0}));
		System.out.println(or.calcularSalida(new int[] {0, 1}));
		System.out.println(or.calcularSalida(new int[] {1, 0}));
		System.out.println(or.calcularSalida(new int[] {1, 1}));
		
		System.out.println("\nCompuerta 'NAND':");
		
		neurona nand = new neurona(new int[] {-1,-1},-2);

		System.out.println(nand.calcularSalida(new int[] {0, 0}));
		System.out.println(nand.calcularSalida(new int[] {0, 1}));
		System.out.println(nand.calcularSalida(new int[] {1, 0}));
		System.out.println(nand.calcularSalida(new int[] {1, 1}));
		
		System.out.println("\nCompuerta 'NOR':");
		
		neurona nor = new neurona(new int[] {-1,-1},-1);

		System.out.println(nor.calcularSalida(new int[] {0, 0}));
		System.out.println(nor.calcularSalida(new int[] {0, 1}));
		System.out.println(nor.calcularSalida(new int[] {1, 0}));
		System.out.println(nor.calcularSalida(new int[] {1, 1}));
		
		System.out.println("\nCompuerta 'NOT': ");
		neurona not = new neurona(new int[] {-1},0);

		System.out.println(not.calcularSalida(new int[] {0}));
		System.out.println(not.calcularSalida(new int[] {1}));
		
		for (int A = 0; A <= 1; A++) {
			for (int B = 0; B <= 1; B++) {
				int salidaOR = or.calcularSalida(new int[] {A, B});
		        int salidaAND = and.calcularSalida(new int[] {A, B});
		        int salidaNOT = not.calcularSalida(new int[] {salidaAND});
		        int salidaXOR = and.calcularSalida(new int[] {salidaOR, salidaNOT});
		        int salidaXNOR = not.calcularSalida(new int[] {salidaXOR});
		        System.out.println("\nTabla XOR y XNOR:");

		        System.out.println( A + " " + B + " | XOR=" + salidaXOR + " XNOR=" + salidaXNOR);
			}
		}
	}
	
	
	
}

