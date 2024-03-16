package kr.co.fmos.theaterBranch;

public class TheaterBranchDTO {
	private int branch_id;
	private String region_id;
	private String branch_name;
	private String branch_address;
	private int branch_number;
	private String branch_img;

	public int getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}

	public String getRegion_id() {
		return region_id;
	}

	public void setRegion_id(String region_id) {
		this.region_id = region_id;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public String getBranch_address() {
		return branch_address;
	}

	public void setBranch_address(String branch_address) {
		this.branch_address = branch_address;
	}

	public int getBranch_number() {
		return branch_number;
	}

	public void setBranch_number(int branch_number) {
		this.branch_number = branch_number;
	}

	public String getBranch_img() {
		return branch_img;
	}

	public void setBranch_img(String branch_img) {
		this.branch_img = branch_img;
	}
}