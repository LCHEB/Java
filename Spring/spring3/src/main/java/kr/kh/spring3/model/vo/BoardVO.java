package kr.kh.spring3.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardVO {
	private int bo_num;
	private int bo_co_num; 
	private String bo_me_id;
	private String bo_title;
	private String bo_content;
	private int bo_view;
	private int bo_report_count;
}
