package day10.word;

public class Word {
	private static int count = 0;
	private String word, mean;
	private int num;
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMean() {
		return mean;
	}

	public void setMean(String mean) {
		this.mean = mean;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	/**수정할 단어와 뜻이 주어지면 단어의 제목과 내용을 수정하는 메서드
	 * @param word1 수정할 제목
	 * @param mean1 수정할 내용
	 */
	public void update(String word1, String mean1) {
		word = word1;
		mean = mean1;
	}

	public void printInfo() {
		System.out.print(num + ". ");
		System.out.print(word + ". ");
		System.out.print(mean + "\n ");
	}
	public void printInfoDetail() {
		System.out.println("번호 : " + num);
		System.out.println("단어 : " + word);
		System.out.println("뜻 : " + mean);
	}
	public Word(String word, String mean) {
		this.num = ++count;
		this.word = word;
		this.mean = mean;
	}
}

