package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the BULLHORN_PROFILE database table.
 * 
 */
@Entity
@Table(name="BULLHORN_PROFILE")
@NamedQuery(name="BullhornProfile.findAll", query="SELECT b FROM BullhornProfile b")
public class BullhornProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	@Temporal(TemporalType.DATE)
	@Column(name="JOIN_DATE")
	private Date joinDate;

	@Column(name="USER_FULLNAME")
	private String userFullname;

	@Column(name="USER_MOTTO")
	private String userMotto;

	@Column(name="USER_PASSWORD")
	private String userPassword;

	//bi-directional many-to-one association to Bullhorn
	@OneToMany(mappedBy="bullhornProfile")
	private List<Bullhorn> bullhorns;

	public BullhornProfile() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getJoinDate() {
		return this.joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getUserFullname() {
		return this.userFullname;
	}

	public void setUserFullname(String userFullname) {
		this.userFullname = userFullname;
	}

	public String getUserMotto() {
		return this.userMotto;
	}

	public void setUserMotto(String userMotto) {
		this.userMotto = userMotto;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public List<Bullhorn> getBullhorns() {
		return this.bullhorns;
	}

	public void setBullhorns(List<Bullhorn> bullhorns) {
		this.bullhorns = bullhorns;
	}

	public Bullhorn addBullhorn(Bullhorn bullhorn) {
		getBullhorns().add(bullhorn);
		bullhorn.setBullhornProfile(this);

		return bullhorn;
	}

	public Bullhorn removeBullhorn(Bullhorn bullhorn) {
		getBullhorns().remove(bullhorn);
		bullhorn.setBullhornProfile(null);

		return bullhorn;
	}

}