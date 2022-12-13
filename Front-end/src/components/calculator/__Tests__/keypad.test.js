import React from "react";
import { render, cleanup, fireEvent } from "@testing-library/react";
import Keypad from "./Keypad";

describe("Keypad", () => {
  afterEach(cleanup);

  it("should render the keypad buttons", () => {
    const { getByText } = render(<Keypad />);
    expect(getByText("7")).toBeInTheDocument();
    expect(getByText("8")).toBeInTheDocument();
    expect(getByText("9")).toBeInTheDocument();
    expect(getByText("DEL")).toBeInTheDocument();
    expect(getByText("4")).toBeInTheDocument();
    expect(getByText("5")).toBeInTheDocument();
    expect(getByText("6")).toBeInTheDocument();
    expect(getByText("+")).toBeInTheDocument();
    expect(getByText("1")).toBeInTheDocument();
    expect(getByText("2")).toBeInTheDocument();
    expect(getByText("3")).toBeInTheDocument();
    expect(getByText("-")).toBeInTheDocument();
  });


  
  it("should call the updateCalc and del functions when buttons are clicked", () => {
    const updateCalc = jest.fn();
    const del = jest.fn();
    const { getByText } = render(<Keypad updateCalc={updateCalc} del={del} />);

    fireEvent.click(getByText("7"));
    expect(updateCalc).toHaveBeenCalledWith("7");
  })

