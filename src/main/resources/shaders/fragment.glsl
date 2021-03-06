#version 460

in  vec2 outTexCoord;
out vec4 fragColor;

uniform sampler2D textureSampler;

void main()
{
    fragColor = texture(textureSampler, outTexCoord);
}