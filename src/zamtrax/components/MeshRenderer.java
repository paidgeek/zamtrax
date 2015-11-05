package zamtrax.components;

import zamtrax.*;
import zamtrax.resources.Material;

public class MeshRenderer extends SceneComponent implements Renderer {

	private MeshFilter meshFilter;
	private Material material;
	private Transform transform;

	@Override
	public void onAdd() {
		transform = getTransform();
		meshFilter = getObject().getComponent(MeshFilter.class);
	}

	@Override
	public void render(Matrix4 viewProjection) {
		Matrix4 model = transform.getLocalToWorldMatrix();
		Matrix4 mvp = viewProjection.mul(model);

		material.bind();
		material.getShader().setUniform("mvp", mvp);

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
