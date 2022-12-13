import ThemeSwitcher from "./ThemeSwitcher";

const Header = ({ HandleThemeChange }) => {
  return (
    <header data-testid="header">
      <h1>calc</h1>
      <ThemeSwitcher data-testid="themeswitcher" HandleThemeChange={HandleThemeChange} />
    </header>
  );
};

export default Header;
