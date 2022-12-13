import React from 'react';
import {render, screen} from '@testing-library/react';
import Screen from './Screen';






describe('Screen', () => {
  it('renders a section with the class "screen"', () => {
    render(<Screen />);
    const screenElement = screen.getByRole('section', {name: /screen/i});
    expect(screenElement).toBeInTheDocument();
  });



  it('renders a p element with the text from the calc prop, or "0" if calc is not provided', () => {
    render(<Screen calc="1 + 1" />);
    const calcElement = screen.getByText(/1 \+ 1/i);
    expect(calcElement).toBeInTheDocument();

    render(<Screen />);
    const defaultElement = screen.getByText(/0/i);
    expect(defaultElement).toBeInTheDocument();
  });

  it('assigns the ref passed to the component to the p element', () => {
    const ref = React.createRef();
    render(<Screen ref={ref} />);
    const element = screen.getByText(/0/i);
  }
  )
  
