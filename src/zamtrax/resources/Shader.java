package zamtrax.resources;

import zamtrax.Color;
import zamtrax.Matrix3;
import zamtrax.Matrix4;
import zamtrax.Vector3;
import zamtrax.components.PointLight;
import zamtrax.components.SpotLight;
import zamtrax.components.Transform;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

public interface Shader {

	void bind();

	void setUniform(CharSequence name, float value);

	void setUniform(CharSequence name, FloatBuffer floatBuffer);

	void setUniform(CharSequence name, int value);

	void setUniform(CharSequence name, boolean normalize, Matrix4 value);

	void setUniform(CharSequence name, boolean normalize, Matrix3 value);

	void setUniform(CharSequence name, Vector3 value);

	void setUniform(CharSequence name, Color value);

	void setPointLights(List<PointLight> pointLights);

	void setSpotLights(List<SpotLight> spotLights);

	void release();

	void dispose();

	class Builder {

		private CharSequence vertexShaderSource;
		private CharSequence fragmentShaderSource;
		private BindingInfo bindingInfo;
		private List<Uniform> uniforms;

		public Builder() {
			uniforms = new ArrayList<>();
		}

		public Builder setVertexShaderSource(CharSequence vertexShaderSource) {
			this.vertexShaderSource = vertexShaderSource;

			return this;
		}

		public Builder setFragmentShaderSource(CharSequence fragmentShaderSource) {
			this.fragmentShaderSource = fragmentShaderSource;

			return this;
		}

		public Builder setBindingInfo(BindingInfo bindingInfo) {
			this.bindingInfo = bindingInfo;

			return this;
		}

		public Builder addUniform(CharSequence name) {
			uniforms.add(new Uniform(name));

			return this;
		}

		public Shader build() {
			Shader shader = new ShaderProgram(vertexShaderSource, fragmentShaderSource, bindingInfo, uniforms);

			return shader;
		}

	}

}
