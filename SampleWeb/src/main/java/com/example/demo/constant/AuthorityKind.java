package com.example.demo.constant;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ユーザー権限種別
 * 
 * @author ys-fj
 */
@Getter
@AllArgsConstructor
public enum AuthorityKind {

	/* 登録内容が不正 */
	UNKNOWN("", "Unknown"),

	/* 商品情報の確認が可能 */
//	ITEM_WATCHER("1", "Able to check product information"),
	ITEM_WATCHER("1", "User"),

	/* 商品情報の確認、更新が可能 */
//	ITEM_MANAGER("2", "Able to check and update product information"),
	ITEM_MANAGER("2", "Manager"),

	/* 商品情報の確認、更新、全ユーザー情報の管理が可能 */
//	ITEM_AND_USER_MANAGER("3", "Able to check and update product information and manage all user information");
	ITEM_AND_USER_MANAGER("3", "Admin");

	/** コード値 */
	private String code;

	/** 画面表示する説明文 */
	private String displayValue;
	
	public static AuthorityKind from(String code) {
		return Arrays.stream(AuthorityKind.values())
				.filter(authorityKind -> authorityKind.getCode().equals(code))
				.findFirst()
				.orElse(UNKNOWN);
	}

}