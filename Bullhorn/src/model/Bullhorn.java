package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the BULLHORN database table.
 * 
 */
@Entity
@NamedQuery(name="Bullhorn.findAll", query="SELECT b FROM Bullhorn b")
public class Bullhorn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ID")
	private long userId;

	private String post;

	@Temporal(TemporalType.DATE)
	@Column(name="POST_DATE")
	private Date postDate;

	//bi-directional many-to-one association to BullhornProfile
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private BullhornProfile bullhornProfile;

	public Bullhorn() {
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Date getPostDate() {
		return this.postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public BullhornProfile getBullhornProfile() {
		return this.bullhornProfile;
	}

	public void setBullhornProfile(BullhornProfile bullhornProfile) {
		this.bullhornProfile = bullhornProfile;
	}

}