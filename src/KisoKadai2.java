import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class KisoKadai2 {
	public static void main(String[] args) {
		System.out.println("数当てゲーム　High&Low");
		System.out.println("1～100の数字を入力してください");
		String str = null;
		boolean flg = true;
		Random rnd = new Random();
		int ans = rnd.nextInt(100) + 1;
		while (flg) {
			try {
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(isr);
				str = br.readLine();


				System.out.println("入力値:" + str);
				int num = Integer.parseInt(str);

				if (ans == num) {
					System.out.println("当たり！！");
					break;
				} else if (ans < num) {
					System.out.println("大きいです");
					continue;
				} else if (ans > num) {
					System.out.println("小さいです");
					continue;
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("エラーです。やり直してください。");
			}

			System.out.println("ゲームを終了します");

		}

	}
}
