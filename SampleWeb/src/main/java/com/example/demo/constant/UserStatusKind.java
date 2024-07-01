package com.example.demo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ユーザー状態種別
 * 
 * @author ys-fj
 */
@Getter
@AllArgsConstructor
public enum UserStatusKind {

	/* 利用可能 */
	ENABLED(false, "Usable"),

	/* 利用不可 */
	DISABLED(true, "Unusable");

	/** 利用不可か */
	private boolean isDisabled;

	/** 画面表示する説明文 */
	private String displayValue;

}