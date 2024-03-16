package kr.co.fmos.coupon;

public class CouponDTO {
	private int coupon_id;
	private String coupon_name;
	private int coupon_discount_rate;
	private int coupon_expiration_date;
	private String coupon_status;

	public int getCoupon_id() {
		return coupon_id;
	}

	public void setCoupon_id(int coupon_id) {
		this.coupon_id = coupon_id;
	}

	public String getCoupon_name() {
		return coupon_name;
	}

	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}

	public int getCoupon_discount_rate() {
		return coupon_discount_rate;
	}

	public void setCoupon_discount_rate(int coupon_discount_rate) {
		this.coupon_discount_rate = coupon_discount_rate;
	}

	public int getCoupon_expiration_date() {
		return coupon_expiration_date;
	}

	public void setCoupon_expiration_date(int coupon_expiration_date) {
		this.coupon_expiration_date = coupon_expiration_date;
	}

	public String getCoupon_status() {
		return coupon_status;
	}

	public void setCoupon_status(String coupon_status) {
		this.coupon_status = coupon_status;
	}
}
