import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class KisoKadai3 {

	public static void main(String args[]) throws IOException {
		System.out.println("--処理開始--");

		int end = 0;
		while (end == 0) {

			System.out.println("\n\n--メニュー--\n\n00:ディレクトリ・ファイルのリストを表示\n1:読み込み \n2:書き込み \n 88:新規作成\n 99:終了\nを入力してください");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			int num = 0;

			if (str.matches("^[0-9]+$")) {
				num = Integer.parseInt(str);
			} else {
				System.out.println("\n----------\n半角数値でメニューを選択してください。\n----------\n");
			}

			// 99: 終了
			if (num == 99) {
				System.out.println("終了");
				break;
			}

			if (num == 00) {

				// 00: ディレクトリ・ファイルのリストを表示

				System.out.println("cドライブの中の一覧を表示します");
				System.out.println("                            ");

				File cdirectory = new File("c:\\");

				File filelist[] = cdirectory.listFiles();
				for (int i = 0; i < filelist.length; i++) {

					if (filelist[i].isFile()) {
						System.out.println("[F]" + filelist[i].getName());

					} else if (filelist[i].isDirectory()) {
						System.out.println("[D]" + filelist[i].getName());

					} else {
						System.out.println("[?]" + filelist[i].getName());

					}
				}

			}

			// 88: 新規作成
			if (num == 88) {

				// ディレクトリの新規作成
				try {
					System.out.println("ディレクトリを新規作成します");
					System.out.println("新しく作るディレクトリ名を入力してください");
					System.out.println("例  c:\\～～～");

					String new_directory_name = null;

					InputStreamReader isr = new InputStreamReader(System.in);
					BufferedReader br_new_dir = new BufferedReader(isr);
					new_directory_name = br_new_dir.readLine();

					File new_directory = new File(new_directory_name);

					if (new_directory.mkdirs()) {
						System.out.println("ディレクトリの作成に成功しました");
					} else {
						System.out.println("ディレクトリの作成に失敗しました");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				// ファイルの新規作成

				try {
					System.out.println("ファイルを新規作成します");
					System.out.println("新しく作るファイル名絶対パス名で入力してください");
					System.out.println("例  　c:\\～～～\\～～～");

					String new_file_name = null;

					InputStreamReader isr = new InputStreamReader(System.in);
					BufferedReader br_new_fil = new BufferedReader(isr);
					new_file_name = br_new_fil.readLine();

					File new_file = new File(new_file_name);

					if (new_file.createNewFile()) {
						System.out.println("ファイルの作成に成功しました");
					} else {
						System.out.println("ファイルの作成に失敗しました");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			

			// 1: 読み込み
			if (num == 1) {
				System.out.println("ファイルを読む");

				// ディレクトリの指定

				System.out.println("                                         ");
				System.out.println("読み込みするディレクトリ名を入力してください");
				System.out.println("例　　c:\\～～～");
				String directory_name = null;
				try {
					InputStreamReader isr = new InputStreamReader(System.in);
					BufferedReader br_dir = new BufferedReader(isr);
					directory_name = br_dir.readLine();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			try{
	
				
				String path_dir = directory_name;
				File dir = new File(path_dir);

				if (dir.exists()) {
					if (dir.isFile()) {
						System.out.println("フォルダを選択してください");
						continue;
					}else{
						}
					}
				
				
				
				// フルパスで取得
				System.out.println("--ファイル一覧(フルパス)--");
				File[] files1 = dir.listFiles();
				for (int i = 0; i < files1.length; i++) {
					File file = files1[i];
					if (files1[i].isFile()) {
						// ファイル名表示
						System.out.println(file);
					} else if (files1[i].isDirectory()) {
						// ディレクトリ名表示(※１)
						System.out.println(file);
					}
				}

			}catch(Exception e){
			   e.printStackTrace();
			
			}
				
				
				// ファイルの絶対パスを取得

				System.out.println("読み込みをするファイル名を絶対パス名で入力してください");
				System.out.println("例　　c:\\～～～\\～～～");
				String file_name = null;
				try {
					InputStreamReader isr = new InputStreamReader(System.in);
					BufferedReader br_fil = new BufferedReader(isr);
					file_name = br_fil.readLine();
				} catch (Exception e) {
					e.printStackTrace();
				}
				File file = new File(file_name); // fileオブジェクトの作成
				String path = file.getAbsolutePath();

				System.out.println("File :" + path);

				// 絶対パスで指定されたファイルの確認
				try {

					if (file.exists()) {
						System.out.println("                    ");

					} else {
						System.out.println("ファイルは存在しません");

					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					FileReader filereader = new FileReader(file.getAbsolutePath());

					int ch;
					while ((ch = filereader.read()) != -1) {
						System.out.print((char) ch);
					}

					filereader.close();
				} catch (FileNotFoundException e) {
					System.out.println(e);
				} catch (IOException e) {
					System.out.println(e);
				}
			}

			// 2: 書き込み
			if (num == 2) {

				// ディレクトリの指定

				System.out.println("                                         ");
				System.out.println("書き込みをするディレクトリ名を入力してください");
				System.out.println("例　　c:\\～～～");
				String directory_name = null;
				try {
					InputStreamReader isr = new InputStreamReader(System.in);
					BufferedReader br_dir = new BufferedReader(isr);
					directory_name = br_dir.readLine();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				try{
				String path_dir = directory_name;
				File dir = new File(path_dir);

				if (dir.exists()) {
					if (dir.isFile()) {
						System.out.println("フォルダを選択してください");
						continue;
					}else{
						}
					}
				
				
				
				
				
				// フルパスで取得
				System.out.println("--ファイル一覧(フルパス)--");
				File[] files1 = dir.listFiles();
				for (int i = 0; i < files1.length; i++) {
					File file = files1[i];
					if (files1[i].isFile()) {
						// ファイル名表示
						System.out.println(file);
					} else if (files1[i].isDirectory()) {
						// ディレクトリ名表示(※１)
						System.out.println(file);
					}
				}
				}catch(Exception e){
				
				  
				
				}
					
					
					
				// ファイルの絶対パスを取得

				System.out.println("書き込みをするファイル名を絶対パス名で入力してください");
				System.out.println("例　　c:\\～～～\\～～～");
				String file_name = null;
				try {
					InputStreamReader isr = new InputStreamReader(System.in);
					BufferedReader br_fil = new BufferedReader(isr);
					file_name = br_fil.readLine();
				} catch (Exception e) {
					e.printStackTrace();
				}
				File file = new File(file_name); // fileオブジェクトの作成
				String path = file.getAbsolutePath();

				System.out.println("File :" + path);

				// 絶対パスで指定されたファイルの確認
				try {

					if (file.exists()) {
						System.out.println("                       ");
						
						if (!file.isFile()) {
							System.out.println("ファイルを選択してください");
							continue;
						}else{
							}
						

					} else {
						System.out.println("ファイルは存在しません");

					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				System.out.println("ファイルを書く");
				try {
					boolean mode = false;
					System.out.println("モードの設定。1:追記、2:上書き");
					BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
					String str2 = br2.readLine();
					// モードを決める
					switch (str2) {
					case "1":
						mode = true;
						break;
					case "2":
						mode = false;
					default:
						break;
					}
					// 出力先を作成する
					FileWriter fw = new FileWriter(file.getAbsolutePath(), mode);
					PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

					// 内容を指定する
					BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
					String str3 = br3.readLine();
					pw.println(str3);

					// ファイルに書き出す
					pw.close();

					// 終了メッセージを画面に出力する
					System.out.println("出力が完了しました。");

				} catch (IOException ex) {
					// 例外時処理
					ex.printStackTrace();
				}

			}
		}
		System.out.println("--処理終了--");
	}
}

