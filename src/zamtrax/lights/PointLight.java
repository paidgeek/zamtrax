package zamtrax.lights;

public class PointLight extends Light {

	private float range;

	public PointLight() {
		range = 5.0f;
	}

	public float getRange() {
		return range;
	}

	public void setRange(float range) {
		this.range = range;
	}

}
