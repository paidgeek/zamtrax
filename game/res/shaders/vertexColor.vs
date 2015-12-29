#version 330

in layout(location = 0) vec4 position;
in layout(location = 1) vec4 color;
in layout(location = 2) vec3 normal;

out vec4 vColor;
out vec3 vNormal;
out vec4 vPosition;

uniform mat4 MV;
uniform mat4 P;
uniform mat3 N;

void main()
{
	vec4 mvPosition = MV * position;
	
	vNormal = N * normal;
	vColor = color;
	vPosition = mvPosition;

	gl_Position = P * mvPosition;
}