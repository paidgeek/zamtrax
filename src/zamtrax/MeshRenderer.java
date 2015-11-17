package zamtrax;

import zamtrax.resources.Material;
import zamtrax.resources.Shader;

public class MeshRenderer extends Renderer {

	private MeshFilter meshFilter;
	private Material material;
	private Transform transform;

	@Override
	public void onAdd() {
		super.onAdd();

		transform = getTransform();
		meshFilter = getObject().getComponent(MeshFilter.class);
	}

	@Override
	public void render(Matrix4 viewProjection) {
		Matrix4 modelView = transform.getLocalToWorldMatrix();

		material.bind();

		Shader shader = material.getShader();

		shader.setUniform("projectionMatrix", viewProjection);
		shader.setUniform("modelViewMatrix", modelView);

		//Matrix3 normalMatrix = modelView.toMatrix3().inverted().transposed();
		//shader.setUniform("normalMatrix", normalMatrix);

		meshFilter.getMesh().render();

		material.unbind();
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

}