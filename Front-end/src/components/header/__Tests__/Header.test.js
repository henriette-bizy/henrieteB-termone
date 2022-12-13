import React from 'react';
import { render, cleanup } from '@testing-library/react';
import Header from './Header';

afterEach(cleanup);

describe('Header', () => {
  it('should render the Header component', () => {
    const { getByTestId } = render(<Header />);
    expect(getByTestId('header')).toBeInTheDocument();
  });

  it('should render the correct text in the h1 element', () => {
    const { getByText } = render(<Header />);
    expect(getByText('calc')).toBeInTheDocument();
  });

  it('should render the ThemeSwitcher component', () => {
    const { getByTestId } = render(<Header />);
    expect(getByTestId('themeswitcher')).toBeInTheDocument();
  });

  it('should pass the HandleThemeChange prop to the ThemeSwitcher component', () => {
    const HandleThemeChange = jest.fn();
    const { getByTestId } = render(<Header HandleThemeChange={HandleThemeChange} />);
    const themeSwitcher = getByTestId('themeswitcher');
    expect(themeSwitcher.props.HandleThemeChange).toBe(HandleThemeChange);
  });
});
