function initParametersExamples() {
	const param = funcParameters();
	let html = '';

	$.each(param, function(index, val){
		html += templateCheckbox(val);
	});

	$('[data-parameters="common"]').html(html);
}

function templateCheckbox(obj) {
	return '\
	<div class="test-item">\
		<label>\
			<span class="label-icon">\
				<input type="checkbox">\
				<span class="checkbox"></span>\
			</span>\
			<span>\
				<span class="test-label">' + obj.key + '</span>\
				<span class="test-description">' + (obj.description != '' ? obj.description : '(not yet described)') + '</span>\
			</span>\
		</label>\
	</div>';
}

function funcParameters() {
	return [
		{
			key: 'text',
			type: 'string',
			default: '',
			description: 'Text of message. Accept HTML tags. Remember, if you put HTML, check if are a right sintaxe to prevent bugs with rest of code.'
		},
		{
			key: 'type',
			type: 'string',
			default: 'normal',
			description: 'Type of message. This is the class to add color to message. You can use default class: <code>normal</code>, <code>success</code>, <code>error</code>, <code>info</code> and <code>alert</code>. Note: you can use your custom type, that generate something like <code>msgbox-mycustomtype</code>.'
		},
		{
			key: 'time',
			type: 'int|bool',
			default: '5000',
			description: 'Time to disappear. You can use any number that message keep on screen, or add <code>false</code> for the message not to auto disappear.'
		},
		{
			key: 'class',
			type: 'string',
			default: '',
			description: 'Class to add to message item. Use if you want to add extra class to message. Ex: <code>my-class my-other-class</code>.'
		},
		{
			key: 'x',
			type: 'bool',
			default: 'true',
			description: 'Close button of message. if you use <code>false</code>, remember that the user will not be able to remove the message if the param <code>time</code> is also set to <code>false</code> and if you do not add any button to remove.'
		},
		{
			key: 'removeContainerOnClose',
			type: 'bool',
			default: 'false',
			description: 'Remove container on close. Remove the container of messages on close some message. Maybe util if you use custom container with tag <code>appendTo</code>.'
		},
		{
			key: 'containerCheckItemBeforeRemove',
			type: 'bool',
			default: 'true',
			description: 'Check if has item on container before remove the container. If set to <code>false</code>, when the user close any message, the container will be removed too, otherwise, will be checked if has any other messages on container, and if yes, the container will be not removed until the last message is closed.'
		},
		{
			key: 'success',
			type: 'bool',
			default: 'null',
			description: 'Show success message or error message. This is a shortcut to use <code>true</code> to type success and <code>false</code> to type error. Note: if you use this param, the type param will be ignored.'
		},
		{
			key: 'id',
			type: 'string',
			default: '',
			description: 'ID of item. Add ID to item box, that results on <code>#my-id</code> and <code>data-my-id</code> at same time.'
		},
		{
			key: 'scrollToBottomOnNewMessage',
			type: 'bool',
			default: 'true',
			description: 'Scroll to bottom on new message. If set to <code>true</code>, if the container has much messages, when the new messages comes to stack, the container is auto scrolled to bottom, and if set to <code>false</code>, the container keep on same position on new messages.'
		},
		{
			key: 'custom',
			type: 'bool',
			default: 'false',
			description: 'Complete custom message. If set to <code>true</code> the default classes to item are removed, and you can use complete custom CSS and HTML code.'
		},
		{
			key: 'closeFunc',
			type: 'string|bool',
			default: 'true',
			description: 'Function to execute on click of close button. Define your function normally to receive <code>one</code> paramenter (will be object). Write here the name of your function as string, your function will be called when the user clicks on close button. Note: the messages will be not closed automatically, you need to close programatically.'
		},
		{
			key: 'mouseoverFunc',
			type: 'string|bool',
			default: 'false',
			description: 'Function to execute when the user put the mouse over the message. Define your function normally to receive <code>one</code> paramenter (will be object). Write here the name of your function as string, your function will be called when the user pass the mouse over message.'
		},
		{
			key: 'mouseoutFunc',
			type: 'string|bool',
			default: 'false',
			description: 'Function to execute when the user take the mouse out of the message. Define your function normally to receive <code>one</code> paramenter (will be object). Write here the name of your function as string, your function will be called when the user take the mouse out of the message.'
		},
		{
			key: 'beforeShowFunc',
			type: 'string|bool',
			default: 'false',
			description: 'Function to execute when the user take the mouse out of the message.'
		},
		{
			key: 'afterShowFunc',
			type: 'string|bool',
			default: 'false',
			description: ''
		},
		{
			key: 'clickFunc',
			type: 'string|bool',
			default: 'false',
			description: ''
		},
		{
			key: 'beforeRemoveFunc',
			type: 'string|bool',
			default: 'false',
			description: ''
		},
		{
			key: 'afterRemoveFunc',
			type: 'string|bool',
			default: 'false',
			description: ''
		},


		{
			key: 'themeClass',
			type: 'string',
			default: 'msgpopup-theme-default',
			description: ''
		},
		{
			key: 'defaultTypeClass',
			type: 'string',
			default: 'msgpopup-type',
			description: ''
		},
		{
			key: 'wrapVisibleClass',
			type: 'string',
			default: 'msgpopup-wrap-visible',
			description: ''
		},
		{
			key: 'appendTo',
			type: 'string',
			default: 'body',
			description: ''
		},
		{
			key: 'elToCloneData',
			type: 'string',
			default: 'data-msgpopup-to-clone',
			description: ''
		},
		{
			key: 'containerData',
			type: 'string',
			default: 'data-msgpopup-container',
			description: ''
		},
		{
			key: 'containerClass',
			type: 'string',
			default: 'msgpopup-container',
			description: ''
		},
		{
			key: 'boxContentData',
			type: 'string',
			default: 'data-msgpopup-content',
			description: ''
		},
		{
			key: 'boxContentClass',
			type: 'string',
			default: 'msgpopup-content',
			description: ''
		},
		{
			key: 'boxTextData',
			type: 'string',
			default: 'data-msgpopup-text',
			description: ''
		},
		{
			key: 'boxTextClass',
			type: 'string',
			default: 'msgpopup-text',
			description: ''
		},
		{
			key: 'boxCloneOutputData',
			type: 'string',
			default: 'data-msgpopup-box-clone-output',
			description: ''
		},
		{
			key: 'boxCloneOutputClass',
			type: 'string',
			default: 'msgpopup-box-clone-output',
			description: ''
		},
		{
			key: 'wrapData',
			type: 'string',
			default: 'data-msgpopup-wrap',
			description: ''
		},
		{
			key: 'wrapClass',
			type: 'string',
			default: 'msgpopup-wrap',
			description: ''
		},
		{
			key: 'itemData',
			type: 'string',
			default: 'data-msgpopup-item',
			description: ''
		},
		{
			key: 'itemClass',
			type: 'string',
			default: 'msgpopup-item',
			description: ''
		},
		{
			key: 'boxData',
			type: 'string',
			default: 'data-msgpopup-box',
			description: ''
		},
		{
			key: 'boxClass',
			type: 'string',
			default: 'msgpopup-box',
			description: ''
		},
	];
}

initParametersExamples();

$('body').on('click', 'label', function(){
	return false;
});
