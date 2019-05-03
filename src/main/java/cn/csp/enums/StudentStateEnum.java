package cn.csp.enums;

/**
 * 使用枚举表述学生状态数据字典
 */
public enum StudentStateEnum {

	ATTEND(1, "正常参加"), NOT_ATTEND(0, "未参加"), SEE_DOC(2, "外出就医"), DROPOUT(3, "意外退出");

	private int state;

	private String stateInfo;

	private StudentStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public static StudentStateEnum stateOf(int index) {
		for (StudentStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}

}
