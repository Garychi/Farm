import  {React,Component } from 'react';
import { Label, DropdownButton, MenuItem, Form } from 'react-bootstrap';

var MyDiv = React.createClass({
	render : function(){
		return (
				<div className="defDiv">
					This is div
				</div>
			);
		}
	});
	ReactDOM.render(<MyDiv/>,document.getElementById('example')
);