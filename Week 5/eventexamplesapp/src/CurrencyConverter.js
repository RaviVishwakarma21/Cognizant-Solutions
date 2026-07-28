import React from "react";

class CurrencyConverter extends React.Component {

    constructor() {
        super();

        this.state = {
            amount: "",
            currency: "Euro"
        };
    }

    handleAmount = (e) => {
        this.setState({
            amount: e.target.value
        });
    };

    handleCurrency = (e) => {
        this.setState({
            currency: e.target.value
        });
    };

    handleSubmit = (e) => {

        e.preventDefault();

        const result = this.state.amount * 80;

        alert("Converting to Euro Amount is " + result);
    };

    render() {

        return (

            <div style={{ marginLeft: "30px", marginTop: "20px" }}>

                <h1 style={{ color: "green" }}>
                    Currency Convertor!!!
                </h1>

                <form onSubmit={this.handleSubmit}>

                    <table>

                        <tbody>

                            <tr>
                                <td>Amount:</td>

                                <td>
                                    <input
                                        type="number"
                                        value={this.state.amount}
                                        onChange={this.handleAmount}
                                    />
                                </td>
                            </tr>

                            <tr>
                                <td>Currency:</td>

                                <td>
                                    <input
                                        type="text"
                                        value={this.state.currency}
                                        onChange={this.handleCurrency}
                                    />
                                </td>
                            </tr>

                            <tr>
                                <td></td>

                                <td>
                                    <button type="submit">
                                        Submit
                                    </button>
                                </td>
                            </tr>

                        </tbody>

                    </table>

                </form>

            </div>

        );
    }
}

export default CurrencyConverter;