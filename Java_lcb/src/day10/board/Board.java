package day10.board;

public class Board {
	//정보 : 번호, 제목, 내용, 일자, 작성자, 조회수
	private static int count = 0;
	private int num, view;
	private String title, contents, writer, date;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setSub(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	//기능 :게시글정보를 출력(목록조회), 게시글 정보를 출력(상세조회), getter와 setter, 게시글 수정
	/** 게시글 목록에서 게시글 정보를 출력하는 메서드
	 *  번호. 제목 작성일 작성자 조회수 순으로 출력
	 */
	public void printInfo() {
		System.out.print(num + ". ");
		System.out.print(title + " ");
		System.out.print(date + " ");
		System.out.print(writer + " ");
		System.out.print(view + "\n ");
		//System.out.println();
	}
	/**게시글 상세에게 게시글 정보를 자세히 출력하는 메서드
	 * 번호 : num
	 * 제목 : title
	 * 내용 : contents
	 * 일자 : date
	 * 작성자 : writer
	 * 조회수 : view
	 * 순으로 출력
	 */
	public void printInfoDetail() {
		System.out.println("번호 : " + num);
		System.out.println("제목 : " + title);
		System.out.println("내용 : " + contents);
		System.out.println("일자 : " + date);
		System.out.println("작성자 : " + writer);
		System.out.println("조회수 : " + view);
	}
	/**수정할 제목과 내용이 주어지면 게시글의 제목과 내용을 수정하는 메서드
	 * @param title1 수정할 제목
	 * @param contents1 수정할 내용
	 */
	public void update(String title1, String contents1) {
		title = title1;
		contents = contents1;
	}
	//생성자 : 게시글 번호, 제목, 내용, 작성자, 게시일이 주어진 생성자
	public Board(String title, String contents, String writer, String date) {
		this.num = ++count;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.date = date;
	}
	
}
