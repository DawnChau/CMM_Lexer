import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;


public class Main {
	/**
	 * 打开一个文件输入流，然后读取文件，然后将其进行词法分析，返回词法单元链表
	 * @param filestr
	 * @return
	 * @throws IOException
	 * @throws LexerException 
	 */
	public static LinkedList<Token> getTokenList(String filestr) throws IOException, LexerException {
		FileReader fr;
		fr = new FileReader(filestr);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filestr), "UTF-8"));
		LinkedList<Token> tokenList = Lexer.lexicalAnalyse(br);
		br.close();
		fr.close();
		return tokenList;
	}
	public static void main(String[] args) throws IOException {
			LinkedList<Token> l;
			try {
				l = getTokenList(args[0]);
				Iterator<Token> it = l.iterator();
				while(it.hasNext()){
					Token t = it.next();
					System.out.println(t.toStringWithLine() );
				}
			} catch (LexerException e) {
				e.printStackTrace();
			}
			
	}
}
