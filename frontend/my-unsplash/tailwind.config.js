/** @type {import('tailwindcss').Config} */
export default {
  content: ["./index.html", "./src/**/*.{js,ts,jsx,tsx}"],
  theme: {
    colors: {
      button: "#3DB46D",
      grey: "#BDBDBD",
      brown: "#4F4F4F",
    },
    extend: {
      fontFamily: {
        noto: ["Noto Sans", "sans-serif"],
      },
    },
  },
  plugins: [],
};
