package fri.rg.zamtrax;

import zamtrax.Component;
import zamtrax.Space;
import zamtrax.Vector3;

public class Rotate extends Component {

	private Vector3 angle;

	@Override
	public void update(float delta) {
		getTransform().rotate(angle.mul(delta), Space.WORLD);
		getTransform().rotate(0.0f, 0.0f, delta * 60.0f, Space.SELF);
	}

	public void setAngle(Vector3 angle) {
		this.angle = angle;
	}

}
