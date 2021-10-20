package com.jcpdev.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GbookComment {
	private int board_idx;
	private String name;
	private String content;
	private String wdate;
}
