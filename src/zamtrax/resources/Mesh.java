package zamtrax.resources;

import zamtrax.Vertex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Mesh {

	void build();

	void render();

	void dispose();

	class Builder {

		private static final boolean DEFAULT_IS_DYNAMIC = false;

		private static int id;

		private List<Vertex> vertices;
		private List<Integer> indices;
		private boolean dynamic;
		private BindingInfo bindingInfo;
		private boolean calculateNormals;

		public Builder() {
			vertices = new ArrayList<>();
			indices = new ArrayList<>();
			dynamic = DEFAULT_IS_DYNAMIC;
		}

		public Builder setVertices(List<Vertex> vertices) {
			this.vertices = vertices;

			return this;
		}

		public Builder setVertices(Vertex... vertices) {
			this.vertices.clear();
			this.vertices.addAll(Arrays.asList(vertices));

			return this;
		}

		public Builder addVertex(Vertex vertex) {
			vertices.add(vertex);

			return this;
		}

		public Builder setIndices(List<Integer> indices) {
			this.indices = indices;

			return this;
		}

		public Builder setIndices(Integer... indices) {
			this.indices.clear();
			this.indices.addAll(Arrays.asList(indices));

			return this;
		}

		public Builder setIndices(int... indices) {
			this.indices.clear();

			for (int i : indices) {
				this.indices.add(i);
			}

			return this;
		}

		public Builder setBindingInfo(BindingInfo bindingInfo) {
			this.bindingInfo = bindingInfo;

			return this;
		}

		public Builder setDynamic(boolean dynamic) {
			this.dynamic = dynamic;

			return this;
		}

		public Builder calculateNormals() {
			calculateNormals = true;

			return this;
		}

		public Mesh build() {
			IndexedMesh mesh = new IndexedMesh(id++, vertices, indices, bindingInfo, dynamic);

			if (calculateNormals) {
				mesh.calculateNormals();
			}

			mesh.build();

			return mesh;
		}
	}

}
