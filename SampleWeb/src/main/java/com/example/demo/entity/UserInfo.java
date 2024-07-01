package com.example.demo.entity;

import java.time.LocalDateTime;

import com.example.demo.constant.AuthorityKind;
import com.example.demo.constant.UserStatusKind;
import com.example.demo.entity.converter.UserAuthorityConverter;
import com.example.demo.entity.converter.UserStatusConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Table(name = "user_info")
@Data
@AllArgsConstructor
public class UserInfo {
	@Id
	@Column(name = "login_id")
	private String loginId;

	/** パスワード */
	private String password;

	/** ログイン失敗回数 */
	@Column(name = "login_failure_count")
	private int loginFailureCount = 0;

	/** アカウントロック日時 */
	@Column(name = "account_locked_time")
	private LocalDateTime accountLockedTime;

	/** ユーザー状態種別 */
	@Column(name = "is_disabled")
	@Convert(converter = UserStatusConverter.class)
	private UserStatusKind userStatusKind;

	/** ユーザー権限種別 */
	@Column(name = "authority")
	@Convert(converter = UserAuthorityConverter.class)
	private AuthorityKind authorityKind;

	/** 登録日時 */
	@Column(name = "create_time")
	private LocalDateTime createTime;

	/** 最終更新日時 */
	@Column(name = "update_time")
	private LocalDateTime updateTime;

	/** 最終更新ユーザ */
	@Column(name = "update_user")
	private String updateUser;

	
	public UserInfo() {
		
	}
	
	public UserInfo incrementLoginFailureCount() {
		return new UserInfo(loginId, password, ++loginFailureCount, accountLockedTime, userStatusKind, authorityKind, createTime,
				updateTime, updateUser);
	}
	
	public UserInfo resetLoginFailureInfo() {
		return new UserInfo(loginId, password, 0, null, userStatusKind, authorityKind, createTime, updateTime, updateUser);
	}
	
	public UserInfo updateAccountLocked() {
		return new UserInfo(loginId, password, 0, LocalDateTime.now(), userStatusKind, authorityKind, createTime, updateTime,
				updateUser);
	}
}
