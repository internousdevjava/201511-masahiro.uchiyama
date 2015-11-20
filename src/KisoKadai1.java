public class KisoKadai1 {
	public static void main(String[] args) {

		int i = 1;
		int j = 1;
		try {
			System.out.println("xとyにそれぞれ1～100までの最大値を指定してください");

			System.out.println("xの最大値");
			int x = new java.util.Scanner(System.in).nextInt();

			System.out.println("yの最大値");
			int y = new java.util.Scanner(System.in).nextInt();

			if (x > 100 || x < 1) {

				System.out.println("値が正しくありません。やり直してください。");

			} else if (y > 100 || y < 1) {

				System.out.println("値が正しくありません。やり直してください");

			} else {

				for (i = 1; i <= x; i++) {

					for (j = 1; j <= y; j++) {

						System.out.print(i * j + "\t");

					}
					System.out.println();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("エラーです。F11を押してやり直してください。");

		}

	}
}
