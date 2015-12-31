package zamtrax.rendering;

import zamtrax.Resources;
import zamtrax.resources.Texture;
import zamtrax.resources.Uniform;

import java.util.ArrayList;
import java.util.List;

public class EmptyFilter extends Filter {

	private static EmptyFilter instance;

	private EmptyFilter() {
	}

	public static EmptyFilter getInstance() {
		if (instance == null) {
			String vs = Resources.loadText("shaders/filterEmpty.vs", EmptyFilter.class.getClassLoader());
			String fs = Resources.loadText("shaders/filterEmpty.fs", EmptyFilter.class.getClassLoader());

			List<Uniform> uniforms = new ArrayList<>();

			uniforms.add(new Uniform("depthTexture"));

			instance = new EmptyFilter();
			instance.init(vs, fs, uniforms);
		}

		return instance;
	}

	@Override
	public void updateUniforms(Texture source, RenderState renderState) {
		super.updateUniforms(source, renderState);

		setUniform("depthTexture", 1);
		source.bind(1, 1);
	}

}
