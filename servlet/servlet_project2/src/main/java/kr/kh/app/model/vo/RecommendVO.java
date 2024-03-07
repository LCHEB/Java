package kr.kh.app.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RecommendVO {
	private int re_num;
	private int re_bo_num;
	private String re_me_id;
	private int re_state;
	
	public RecommendVO(String me_id, int boNum, int state) {
		this.re_me_id = me_id;
		this.re_bo_num = boNum;
		this.re_state = state;
	}

}
