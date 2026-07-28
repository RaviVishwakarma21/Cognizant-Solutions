import React from "react";

function ListofIndianPlayers(props) {
    return (
        <div>
            {
                props.IndianPlayers.map((item) => (
                    <li key={item}>
                        Mr. {item}
                    </li>
                ))
            }
        </div>
    );
}

export default ListofIndianPlayers;