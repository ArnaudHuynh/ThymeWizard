const defaultTheme = require('tailwindcss/defaultTheme');

module.exports = {
    content: ['./src/main/resources/templates/**/*.{html, svg}'],
    theme: {
        extend: {
            fontFamily: {
                sans: ['Inter var', ...defaultTheme.fontFamily.sans],
            },
        }
    },
    variants: {
        extend: {},
    },
    plugins: [
        require('@tailwindcss/forms')
    ]
};