package identifier;

public class IdentifierMain {

	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println("Uso: IdentifierMain <string>");
		}else {
			Identifier id = new Identifier();
			if(id.validateIdentifier(args[0])) {
				System.out.print("V�lido");
			}else {
				System.out.print("Inv�lido");
			}
		}
	}
}
