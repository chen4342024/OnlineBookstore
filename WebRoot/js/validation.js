//Error message
/*
var VAL_FIELD_INVALID = "The field is invalid";
var VAL_DATE_FORMAT_INCORRECT = "Date time format is not correct.";
var VAL_ONLY_LETTERS_AND_NUMBERS = "Only letters (a-z, A-Z) and numbers (0,9) are allowed.";
var VAL_ONLY_LETTERS_NUM_SPACE_AND_UNDERCORE = "Only letters (a-z, A-Z),numbers (0,9),space and underscore are allowed.";
var VAL_ONLY_LETTER_NUMBER_AND_SPACE = "Only letters (a-z, A-Z),numbers (0,9),space are allowed.";
var VAL_ONLY_LETTER_NUMBER_ASCII = "Only letters (a-z, A-Z), numbers (0,9) and ASCII keys (Example: !@#$%^&*;:?) are allowed.";
var VAL_FIELD_MANDATORY = "The field is required."; 
var VAL_AT_LEAST_ONE_FIELD_REQUIRED = "At least one of the fields is required.";
var VAL_FIELD_REQUIRED_THIS_TIME = "The field is is required at this time.";
var VAL_EXCEED_MAX_CHARACTERS = "Exceed maximum characters limitation.";
var VAL_ONLY_DIGI_REQUIRED = "Only Digit is required.";
var VAL_EMAIL_ADDRESS_FORMAT_ERROR = "E-mail address is in the form of xxx@xxx.xxx.";
var VAL_EMAIL_ADDRESSES_FORMAT_ERROR = "E-mail address is in the form of xxx@xxx.xxx, and separated with a space";
var VAL_INTEGER_ONLY = "Only integer is valid input.";
var VAL_AREA_MANDATORY = "This area is mandatory.";
var VAL_ONLY_LETTERS_NUMBERS_AND_UNDERCORE = "Only (0,1..9,a,b..z,A,B,..Z and _) is valid.";
var VAL_FLOAT_ONLY = "Only float value is required.";
var VAL_DATE_FORMAT_ERROR_OR_OUT_OF_RANGE = "The date is mis-formated or out of range.";
*/
var VAL_FIELD_INVALID = "该输入无效";
var VAL_DATE_FORMAT_INCORRECT = "日期格式不正确";
var VAL_ONLY_LETTERS_AND_NUMBERS = "只允许填字母及数字";
var VAL_ONLY_LETTERS_NUM_SPACE_AND_UNDERCORE = "只允许填字母及数字、空格、下划线.";
var VAL_ONLY_LETTER_NUMBER_AND_SPACE = "只允许填字母及数字、空格.";
var VAL_ONLY_LETTER_NUMBER_ASCII = "Only letters (a-z, A-Z), numbers (0,9) and ASCII keys (Example: !@#$%^&*;:?) are allowed.";
var VAL_FIELD_MANDATORY = "该输入框必填"; 
var VAL_AT_LEAST_ONE_FIELD_REQUIRED = "At least one of the fields is required.";
var VAL_FIELD_REQUIRED_THIS_TIME = "The field is is required at this time.";
var VAL_EXCEED_MAX_CHARACTERS = "Exceed maximum characters limitation.";
var VAL_ONLY_DIGI_REQUIRED = "Only Digit is required.";
var VAL_EMAIL_ADDRESS_FORMAT_ERROR = "邮件格式不对，格式应为: xxx@xxx.xxx.";
var VAL_EMAIL_ADDRESSES_FORMAT_ERROR = "E-mail address is in the form of xxx@xxx.xxx, and separated with a space";
var VAL_INTEGER_ONLY = "只允许填入数字.";
var VAL_AREA_MANDATORY = "此区域为必填.";
var VAL_ONLY_LETTERS_NUMBERS_AND_UNDERCORE = "只允许填字母及数字、下划线.";
var VAL_FLOAT_ONLY = "只允许填小数";
var VAL_DATE_FORMAT_ERROR_OR_OUT_OF_RANGE = "该日期超出范围.";

function changeValidateMessage() {
	if(typeof(mldd_array) != "undefined") {
		VAL_FIELD_INVALID = mldd_array['nvo.message.field_invalid'] || VAL_FIELD_INVALID;
		VAL_DATE_FORMAT_INCORRECT = mldd_array["nvo.cmm.warn.date_format_not_correct"] || VAL_DATE_FORMAT_INCORRECT;
		VAL_ONLY_LETTERS_AND_NUMBERS = mldd_array["cmm.validate.err.only_letters_numbers"] || VAL_ONLY_LETTERS_AND_NUMBERS;
		VAL_ONLY_LETTERS_NUM_SPACE_AND_UNDERCORE = mldd_array["cmm.validate.err.only_letters_num_space"] || VAL_ONLY_LETTERS_NUM_SPACE_AND_UNDERCORE;
		VAL_ONLY_LETTER_NUMBER_AND_SPACE = mldd_array["cmm.validate.err.only_letters_numbers"] || VAL_ONLY_LETTER_NUMBER_AND_SPACE; 
		VAL_ONLY_LETTER_NUMBER_ASCII = mldd_array["nvo.cmm.error.only_letter_number_ascii"] || VAL_ONLY_LETTER_NUMBER_ASCII;
		VAL_FIELD_MANDATORY = mldd_array["si.err.draf_temp_name_requ"] || VAL_FIELD_MANDATORY; 
		VAL_AT_LEAST_ONE_FIELD_REQUIRED = mldd_array["cmm.validate.error.req_one_field"] || VAL_AT_LEAST_ONE_FIELD_REQUIRED;
		VAL_FIELD_REQUIRED_THIS_TIME = mldd_array["cmm.validate.error.req_this_time"] || VAL_FIELD_REQUIRED_THIS_TIME;
		VAL_EXCEED_MAX_CHARACTERS = mldd_array["cmm.validate.error.exceed_max_characters"] || VAL_EXCEED_MAX_CHARACTERS;
		VAL_ONLY_DIGI_REQUIRED = mldd_array["si.warn.digit_only_for_fax"] || VAL_ONLY_DIGI_REQUIRED;
		VAL_EMAIL_ADDRESS_FORMAT_ERROR = mldd_array["cmm.error.format_email"] || VAL_EMAIL_ADDRESS_FORMAT_ERROR;
		VAL_EMAIL_ADDRESSES_FORMAT_ERROR = mldd_array["cmm.validate.err.email_addr_invalid"] || VAL_EMAIL_ADDRESSES_FORMAT_ERROR;
		VAL_INTEGER_ONLY = mldd_array["cmm.validate.err.only_allow_int_input"] || VAL_INTEGER_ONLY;
		VAL_AREA_MANDATORY = mldd_array["cmm.validate.error.mandatory_area"] || VAL_AREA_MANDATORY;
		VAL_ONLY_LETTERS_NUMBERS_AND_UNDERCORE = mldd_array["cmm.validate.error.only_letter_num"] || VAL_ONLY_LETTERS_NUMBERS_AND_UNDERCORE;
		VAL_FLOAT_ONLY = mldd_array["cmm.validate.error.only_float_required"] || VAL_FLOAT_ONLY;
		VAL_DATE_FORMAT_ERROR_OR_OUT_OF_RANGE = mldd_array["cmm.validate.error.date_invalid"] || VAL_DATE_FORMAT_ERROR_OR_OUT_OF_RANGE;
	}
}

changeValidateMessage();
//////////////////////////////////////////////////////////////////////////////////////////////
var Obj = {};
Obj.inherit = function(subPrototype, baseObject) {
    for (var p in baseObject) {
        if (!subPrototype[p]) {
            subPrototype[p] = baseObject[p];
        }
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////
var ValidatableElementBase = {
    addToParentManager: function() {
        var parentNode = this.element.parentNode;
        while (parentNode && !parentNode.validationManager) {
            parentNode = parentNode.parentNode;
        }
        if (!parentNode) {
            throw new Error("there is no validation manager set for this validation manager:" + this.element);
        }
        parentNode.validationManager.add(this, this.options.sequence);
        this.manager = parentNode.validationManager;
    },

    toDomElement: function(element) {
        if (!element) {
            throw new Error("No element reference or element id has been provided!");
        }
        var domElement = element.nodeName ? element : (document.getElementById(element) || document.getElementById("form:" + element));
        if (!domElement) {
            throw new Error("No element with reference or id of '" + element + "' exists!");
        }
        return domElement;
    },

    exist: function() {
        if (!this.element) {
            throw new Error("this validation element has no inner dom element.");
        }
        var parent = this.element;
        while (parent.nodeType != 9) {
            parent = parent.parentNode;
            if (!parent) {
                return false;
            }
        }
        return true;
    },

    verifyExisting: function(value) {
        if (!value) {
            throw new Error("the value should exist at this case!");
        }
        return value;
    },

    mergeOptions: function(options) {
        for (var o in options) {
            if (!this.options[o]) {
                this.options[o] = options[o];
            }
        }
        return this;
    },

    updateOptions: function(options) {
        for (var o in options) {
            this.options[o] = options[o];
        }
        return this;
    }
}

///////////////////////////////////
function ValidationManager(options) {
    this.options = options ||
                   {};
    this.mergeOptions({
        sequence: 0
    });
    this.element = null;
    this.cascade = false;
    this.valid = true;
    this.validationElements = [];
    this.errorListenerIds = [];
    this.oldValidationFuns = [];
    this.elementsWithError = [];
}

ValidationManager.prototype = {
    /*
     element : dom element this manager bind to
     cascade : whether or not adding this manager to it's parent manager as a validation element
     */
    bind: function(element, cascade) {
        this.element = this.toDomElement(element);
        this.element.validationManager = this;

        this.cascade = cascade;
        if (this.cascade) {
            this.addToParentManager();
        }
        return this;
    },

    applyToButton: function(buttonElement) {
        var self = this;
        var button = this.toDomElement(buttonElement);
        var oldOnClick = button.onclick ||
                         function() {
                         };
        button.onclick = function(e) {
            if (self.validate(Validation.Level.Relation)) {
                return oldOnClick.call(this, e);
            }
        };
    },

    add: function(validationElement, sequence) {
        for (var i = 0, len = this.validationElements.length; i < len; i++) {
            var e = this.validationElements[i];
            if (e.options.sequence > sequence) {
                this.validationElements.splice(i, 0, validationElement);
                return;
            }
        }
        this.validationElements.push(validationElement);
    },
    
    remove : function(validationElement) {
    	for ( var i = 0, n = 0; i < this.validationElements.length; i++) {
    		if (this.validationElements[i] != validationElement) {
    			this.validationElements[n++] = this.validationElements[i]
    		}
    	}
    	this.validationElements.length -= 1;
    },

    reset: function() {
        for (var i = 0, len = this.validationElements.length; i < len; ++i) {
            this.validationElements[i].reset();
        }
    },

    getValidationElementOf: function(element) {
        var dom = this.toDomElement(element);
        for (var i = 0, len = this.validationElements.length; i < len; i++) {
            if (this.validationElements[i].element === dom) {
                return this.validationElements[i];
            }
        }
    },

    setupErrorListenerIds: function() {
        this.errorListenerIds = [];
        for (var i = 0, len = arguments.length; i < len; i++) {
            this.errorListenerIds.push(arguments[i]);
        }
    },

    addFun: function() {
        for (var i = 0, len = arguments.length; i < len; i++) {
            this.oldValidationFuns.push(arguments[i]);
        }
    },

    validateWithRelationLevel: function() {
        return this.validate(Validation.Level.Relation);
    },

    validateWithDraftLevel: function() {
        return this.validate(Validation.Level.Draft);
    },

    validate: function(level, ignoreOldStyleValidation) {
        var itself = this;
        this.valid = true;
        if (!ignoreOldStyleValidation) {
            var meaningfulOldValidationFuns = [];

            $.each(itself.oldValidationFuns, function(i, val) {
                var result = val();
                var meaningfulFun = true;
                if (result !== false && result !== true) {
                    throw "all validation function should return boolean!";
                }
                if (!result) {
                    if (val.sourceElement && !itself.bubbleError(val.sourceElement)) {
                        meaningfulFun = false;
                    }
                    else {
                        itself.valid = false;
                    }
                }
                if (meaningfulFun) {
                    meaningfulOldValidationFuns.push(val);
                }
            });
            itself.oldValidationFuns = meaningfulOldValidationFuns;
        }

        this.elementsWithError = [];
        for (var i = 0, len = this.validationElements.length; i < len; ++i) {
            var v = this.validationElements[i];
            if (!v.exist()) {
                this.validationElements.splice(i, 1); // remove from list
                i--;
                len--;
                continue;
            }
            if (!v.validate(level)) {
                this.elementsWithError.push(v.element);
                this.valid = false;
                this.bubbleError(v.element, v);
            }
        }
        return this.valid;
    },

    // return false if sourceElement is unbind from document dom tree.
    bubbleError: function(sourceElement, validationElement) {
        if (!sourceElement) {
            throw new Error("invalid sourceElement.");
        }
        var parent = this.toDomElement(sourceElement);
        var DOCUMENT_NODE_TYPE = 9;
        while (parent.nodeType != DOCUMENT_NODE_TYPE) {
            if (this.isTabDiv(parent)) {
                $("#" + parent.id).trigger("validationError");
                break;
            }
            parent = parent.parentNode;
            if (!parent) {
                return false;
            }
        }
        return true;
    },

    isTabDiv: function(element) {
        for (var i = 0; i < this.errorListenerIds.length; i++) {
            if (this.errorListenerIds[i] == element.id) {
                return true;
            }
        }
        return false;
    }
}

Obj.inherit(ValidationManager.prototype, ValidatableElementBase);

var is_validating_draft_dirty_evil = false;

var ValidationCenter = new ValidationManager();

$(document).ready(function () {
    // $('body') does not work in IE, so use document.body
    ValidationCenter.bind(document.body);
});

//////////////////////////////////////////////////////////////////////
function Validation(elements, options) {
    this.options = options ? options : {};
    this.valid = true;
    this.validationObjs = [];
    this.validationElements = [];

    this.init(elements);
}

Validation.Level = {
    Warning: 1,
    Draft: 2,
    Self: 3,
    Relation: 4
}

Validation.prototype = {
    init: function(elements) {
        var associatedValidation = this.options.associatedValidation;
        if (associatedValidation && !(associatedValidation instanceof Validation)) {
            throw Error("associatedValidation option should be a validation object.");
        }
        this.associatorValidationElement = associatedValidation ? associatedValidation.validationElements[0] : null;

        var elementArray = [];
        if (elements instanceof Array) {
            elementArray = elements;
        }
        else {
            elementArray.push(elements);
        }
        this.setupElements(elementArray);
    },

    addWarning: function(validationFunction, validationOptionsObj) {
        var options = validationOptionsObj ||
                      {};
        options.level = Validation.Level.Warning;
        return this.add(validationFunction, options);
    },

    addDraft: function(validationFunction, validationOptionsObj) {
        var options = validationOptionsObj ||
                      {};
        options.level = Validation.Level.Draft;
        return this.add(validationFunction, options);
    },

    addSelf: function(validationFunction, validationOptionsObj) {
        var options = validationOptionsObj ||
                      {};
        options.level = Validation.Level.Self;
        return this.add(validationFunction, options);
    },

    addRelation: function(validationFunction, validationOptionsObj) {
        var options = validationOptionsObj ||
                      {};
        options.level = Validation.Level.Relation;
        return this.add(validationFunction, options);
    },

    add: function(validationFunction, validationOptionsObj) {
        var options = this.mergeWithMyOptions(validationOptionsObj);

        options.level = options.level || Validation.Level.Self;
        options.message = options.message || validationFunction.message || VAL_FIELD_INVALID;
        options.onlyIf = options.onlyIf ||
                         function() {
                             return true;
                         };
        this.validationObjs.push({
            fun: validationFunction,
            options: options
        });
        return this;
    },

    validate: function(level) {
        for (var i = 0, len = this.validationElements.length; i < len; i++) {
            this.validationElements[i].validate(level);
        }
    },
    
    isValid : function(level) {
        var validResult = true;
    	for (var i = 0, len = this.validationElements.length; i < len; i++) {
    		if(!this.validationElements[i].validate(level)){
    			validResult = false;
    		}
        }
    	return validResult;
    },

    mergeWithMyOptions: function(options) {
        var mergedOptions = {};
        for (var p in this.options) {
            mergedOptions[p] = this.options[p];
        }
        for (var p in options) {
            mergedOptions[p] = options[p];
        }
        return mergedOptions;
    },

    validateOneElement: function(element, level) {
        var valid = true;
        var message = null;

        for (var i = 0, len = this.validationObjs.length; i < len; ++i) {
            var v = this.validationObjs[i];
            if (this.needApplyThisValidationObj(v, level)) {
                if (!v.fun(element, v.options)) {
                    message = ValidationCenter.verifyExisting(v.options.message);
                    if (v.options.level === Validation.Level.Warning) {
                        continue;
                    }
                    valid = false;
                    break;
                }
            }
        }

        return {
            valid: valid,
            message: message
        };
    },

    reset: function() {
        $.each(this.validationElements, function(i, e) {
            e.reset.call(e);
        });
    },

    needApplyThisValidationObj: function(validationObj, level) {
        return validationObj.options.level <= level && validationObj.options.onlyIf();
    },

    setupElements: function(elements) {
        if (!elements) {
            throw new Error("No element reference or element id has been provided!");
        }
        this.validationElements = [];
        for (var i = 0, len = elements.length; i < len; i++) {
            var validationElement = new ValidationElement(elements[i], this, this.options);
            this.validationElements.push(validationElement);
            if (this.associatorValidationElement) {
                this.associatorValidationElement.associate(validationElement);
            }
            else {
                validationElement.addToParentManager();
            }
        }
    }
}

/////////////////////////////////
function ValidationElement(element, validation, options) {
    if (!validation) {
        throw new Error("the validation passed in has not been provided.");
    }
    this.element = null;
    this.validation = validation;
    this.options = options ||
                   {};
    this.mergeOptions({
        sequence: 0
    });

    this.role = ValidationElement.Role.Alone;
    this.valid = true;
    this.message = null;
    this.previousCheck = {};
    this.associatedValidationElements = [];

    this.init(element);
}

ValidationElement.Role = {
    Alone: 0,
    Associatee: 1,
    Associator: 2
};

ValidationElement.prototype = {
    addToParentManager: function() {
        ValidatableElementBase.addToParentManager.call(this);
        this.mergeOptions(this.manager.options);
    },

    init: function(element) {
        var self = this;
        this.element = this.toDomElement(element);
        this.element.validationElement = this;

        var selfCheckEvent = this.options.selfCheckEvent ? this.options.selfCheckEvent : "onblur";
        this.oldSelfCheck = this.element[selfCheckEvent] ||
                            function() {
                            };
        this.element[selfCheckEvent] = function(e) {
            self.oldSelfCheck.call(this, e);
            self.doSelfCheck();
        };
        this.associatedByElement = null;
    },

    validateMe: function(level) {
        var warning = null;
        var errors = [];

        if (this.isElementEditable()) {
            if (this.checkIsNotNecessary(level)) {
                this.valid = this.previousCheck.valid;
                return this.previousCheck.result;
            }
            var result = this.validation.validateOneElement(this.element, level);
            if (!result.valid) {
                this.valid = false;
                errors.push(this.verifyExisting(result.message));
            }
            else
                if (result.message) {
                    warning = result.message;
                }
        }

        var validateResult = {
            warning: warning,
            errors: errors
        };
        this.previousCheck = {
            valid: this.valid,
            value: this.element.value,
            level: level,
            result: validateResult
        };
        return validateResult;
    },

    checkIsNotNecessary: function(level) {
        return this.options.smartCheck && this.previousCheck.value === this.element.value && this.previousCheck.level <= level;
    },

    validateAssociatedElements: function(level, triggeredByElement) {
        var warning = null;
        var errors = [];

        for (var i = 0, len = this.associatedValidationElements.length; i < len; i++) {
            var associatedElement = this.associatedValidationElements[i];
            if (!associatedElement.validate(level, triggeredByElement)) {
                this.valid = false;
                var errorMessage = this.verifyExisting(associatedElement.message);
                if (associatedElement === triggeredByElement) {
                    errors.unshift(errorMessage);
                }
                else {
                    errors.push(errorMessage);
                }
            }
            else
                if (associatedElement.message) {
                    warning = associatedElement.message;
                }
        }

        return {
            warning: warning,
            errors: errors
        };
    },

    validate: function(level, triggeredByElement) {
        this.valid = true;
        this.message = null;

        var associatedMessages = this.validateAssociatedElements(level, triggeredByElement);
        var myMessages = {
            errors: []
        };
        if (this.valid) {
            myMessages = this.validateMe(level);
        }

        if (!this.valid) {
            this.message = this.verifyExisting(associatedMessages.errors.concat(myMessages.errors)[0]);
        }
        else
            if (associatedMessages.warning) {
                this.message = associatedMessages.warning;
            }
            else
                if (myMessages.warning) {
                    this.message = myMessages.warning;
                }

        if (this.validation.options.onPrompt) {
            this.validation.options.onPrompt(this.message);
        }
        else {
            this.message ? this.showPrompt() : this.clearPrompt();
        }
        return this.valid;
    },

    reset: function() {
        this.valid = true;
        this.message = null;
        this.clearPrompt();
        for (var i = 0, len = this.associatedValidationElements.length; i < len; i++) {
            this.associatedValidationElements[i].reset();
        }
    },

    associatedBy: function(validationElement) {
        this.role = ValidationElement.Role.Associatee;
        this.associatedByElement = validationElement;
        this.mergeOptions(validationElement.manager.options);
    },

    associate: function(validationElement) {
        validationElement.associatedBy(this);

        this.role = ValidationElement.Role.Associator;
        this.associatedValidationElements.push(validationElement);
    },

    doSelfCheck: function() {
        var level = this.options.levelOfSelfCheck || Validation.Level.Self;
        if (this.role === ValidationElement.Role.Associatee) {
            this.associatedByElement.validate(level, this);
        }
        else {
            this.validate(level);
        }
    },

    isElementEditable: function() {
        return this.element.style.display != "none" &&
               !this.element.disabled &&
               this.element.className.indexOf("disabledBox") === -1;
    },

    clearPrompt: function() {
        var holder = this.getPromptHolder();
        if (holder) {
            $(holder).remove();
        }
        var errorBoxClass = typeof this.options.errorBoxClass === "string" ? this.options.errorBoxClass : "errorBox";
        if($(this.element).hasClass(errorBoxClass)){
        	$(this.element).removeClass(errorBoxClass);
        }
    },

    showPrompt: function() {
        if (this.role !== ValidationElement.Role.Associatee) {
            this.setupPromptHolder(this.message);
        }
        if (this.role !== ValidationElement.Role.Associator) {
            var errorBoxClass = typeof this.options.errorBoxClass === "string" ? this.options.errorBoxClass : "errorBox";
            if (this.inWarningState()) {
            	if($(this.element).hasClass(errorBoxClass)) {
                	$(this.element).removeClass(errorBoxClass);
            	}
            }
            else {
                $(this.element).addClass(errorBoxClass);
            }
        }
    },

    inWarningState: function() {
        return this.valid && this.message;
    },

    getPromptHolder: function() {
        return $(this.element).next("span[name='promptHolderDiv']")[0];
    },

    setupPromptHolder: function(promptMsg) {
        var holder = this.getPromptHolder();
        if (!holder) {
            holder = document.createElement("span");
            holder.id = this.element.id + "ErrorMsgHolder"; // used in selenium tests
            $(holder).attr("name","promptHolderDiv");
            $(this.element).after(holder);
        }
        var holderJQuery = $(holder);
        holderJQuery.html(promptMsg);

        var errorMsgClass = this.options.errorMsgClass || "errorIconAndMsg";

        holderJQuery.removeClass("alertMsg");
        holderJQuery.removeClass(errorMsgClass);

        holderJQuery.addClass(this.inWarningState() ? "alertMsg" : errorMsgClass);
        holderJQuery.css('display','');
    }
}

Obj.inherit(ValidationElement.prototype, ValidatableElementBase);

function isNotEmptyElement(element) {
    if (element.nodeName === "SELECT"){
       return element.options[element.selectedIndex].text !== 'Select'
    	    && element.options[element.selectedIndex].value != ""
    	    && $(element.options[element.selectedIndex]).attr("emptyOption") != "true";
    }
    if (element.type == 'radio' || element.type == 'checkbox') {
        return element.checked;
    }
    else {
        return $.trim(element.value) !== "";
    }
}

function isMatchRegex(regexString, element) {
	var value = element.nodeName ? element.value : element;
	var regex = new RegExp(regexString);
	return regex.test(value);
}

//////////////////////////////////////////////////////////////////////////////////////////////
var ValidateFun = {};

ValidateFun.DatePickerDatetimeFormatValidation = function(element) {
	if(element.value != null){
		var myDate = element.value;
		if(myDate == "" || myDate == "dd mmm yyyy, hh:mm" || myDate == "dd mmm yyyy")
			return true;
		
		var longFormatRegex = /^(0\d{1}|[12]\d{1}|3[01]) (\D{3}) (\d{4})(, ([01]\d{1}|2[0-3]):([0-5]\d{1}))?$/;
		var array = longFormatRegex.exec(myDate);
		
		if (array != null) {
			var d = parseInt(array[1]);
			var m = array[2];
			var y = parseInt(array[3]);
			switch (m) {
			case 'Jan':
			case 'Mar':
			case 'May':
			case 'Jul':
			case 'Aug':
			case 'Oct':
			case 'Dec':
				if (d > 31) {
					return false;
				} else {
					return true;
				}
				break;
			case 'Feb':
				if (((((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0)) && d > 29) || ((!(((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0)) && d > 28))) {
					return false;
				} else {
					return true;
				}
				break;
			case 'Apr':
			case 'Jun':
			case 'Sep':
			case 'Nov':
				if (d > 30) {
					return false;
				} else {
					return true;
				}
				break;
			default:
				return false;
			}
		} else {
			return false;
		}
	}
};
ValidateFun.DatePickerDatetimeFormatValidation.message = VAL_DATE_FORMAT_INCORRECT;

ValidateFun.LetterNumberChars = function(element,options) {
	var value = element.nodeName ? element.value : element;
	if(options.trimValue){
		value=$.trim(value);
	}
	return !isMatchRegex("[^a-zA-Z0-9]" ,value)
};

ValidateFun.NumberOnly = function(element,options) {
	var value = element.nodeName ? element.value : element;
	if(options.trimValue){
		value=$.trim(value);
	}
	return !isMatchRegex("[^0-9]" ,value)
};

ValidateFun.LetterNumberChars.message = VAL_ONLY_LETTERS_AND_NUMBERS;

ValidateFun.LetterNumberSpaceUnderscore = function(element) {
	return isMatchRegex("^[A-Za-z0-9_ ]{1,60}$" ,element)
};

ValidateFun.LetterNumberSpaceUnderscore.message = VAL_ONLY_LETTERS_NUM_SPACE_AND_UNDERCORE;

ValidateFun.LetterNumberSpace = function(element) {
	var value = $.trim(element.value);
    if (!value || value === "") {
        return true;
    }
	return isMatchRegex("^[a-zA-Z0-9 ]{1,60}$" ,element);
};

ValidateFun.LetterNumberSpace.message = VAL_ONLY_LETTER_NUMBER_AND_SPACE;

ValidateFun.AsciiChars = function(element) {
    return isMatchRegex("^([\\w_ \"'&.\\-;\\\\~`!@#$%\\^\\*\\(\\)\\+\\=\\|\\[\\]\\{\\}:,\\>\\<?/\\r\\n])*$" ,element)
};

ValidateFun.AsciiChars.message = VAL_ONLY_LETTER_NUMBER_ASCII;

ValidateFun.AsciiSingleChar = function(element){
    return isMatchRegex("^([\\w_ \"'&.\\-;\\\\~`!@#$%\\^\\*\\(\\)\\+\\=\\|\\[\\]\\{\\}:,\\>\\<?/\\r\\n])*$" ,element)
    
};

ValidateFun.EachLineAsciiChars = function(element) {
    var lines = element.value.split("\r\n");
    for (var i = 0, len = lines.length; i < len; i++) {
        if (!ValidateFun.AsciiChars(lines[i])) {
            return false;
        }
    }
    return true;
};

ValidateFun.EachLineAsciiChars.message = VAL_ONLY_LETTER_NUMBER_ASCII;

ValidateFun.Mandatory = function(element) {
    if (element.nodeName === "SELECT") {
        if (element.size <= 1) {
            if(element.selectedIndex > 0){
                return true;
            }
            if(element.selectedIndex === -1){
                return false;
            }
            //add to support MLDD in select, 
            //if the option "Select" is support MLDD, please add the attribute for the option
            //when the option is not rendered by JSF <f:selectItem>
            if($(element.options[element.selectedIndex]).attr("emptyOption") == "true") {
            	return false;
            }
            if(element.options[element.selectedIndex].text === 'Select'){
                return false;
            }
            if(element.selectedIndex === 0 && element.options[element.selectedIndex].value === ''){
                return false;
            }
            return true;
        }
        else {
            return element.length > 0;
        }
    }
    else
    	if (element.nodeName === "INPUT" && $(element).attr("class") && $(element).attr("class").indexOf("Wdate") != -1) {
            return !isNaN(Date.parse(element.value));
        }

    return isNotEmptyElement(element);
};

ValidateFun.isShorterThanMaxLength = function(element, options) {
  if (!element.value) {
    return true;
  }
  var totalChars = element.value;
  var matchArr = jQuery.browser.msie ? null : element.value.match(/(\r)?\n/g);
  var matchTimes = (matchArr) ? matchArr.length : 0;
  var elementLength = 0;
  for (var i = 0, len = totalChars.length; i < len; i++) {
    if (ValidateFun.AsciiSingleChar(totalChars.charAt(i))) {
      elementLength ++;
    } else {
      elementLength = elementLength + 3;
    }
  }
  return ((elementLength + matchTimes) <= options.limit);
}

/**
 * oracle database use varchar2, need convert ui characters 
 * to utf-8 bytes length for valiation 
 * **/
ValidateFun.isShorterThanMaxBytesLength = function(element, options) {
  if (!element.value) {
    return true;
  }
  var totalChars = element.value;
  var matchArr = jQuery.browser.msie ? null : element.value.match(/(\r)?\n/g);
  var matchTimes = (matchArr) ? matchArr.length : 0;
  var elementLength = element.value.getUTF8BytesLength();
  return ((elementLength + matchTimes) <= options.limit);
}

ValidateFun.Mandatory.message = VAL_FIELD_MANDATORY;

ValidateFun.MandatoryWithOther = function(element, options) {
    var otherControl = options.other.nodeName ? options.other : (document.getElementById(options.other) || document.getElementById('form:' + options.other));
    return isNotEmptyElement(otherControl) || isNotEmptyElement(element);
};

ValidateFun.MandatoryWithOther.message = VAL_AT_LEAST_ONE_FIELD_REQUIRED;

ValidateFun.MandatoryWithOthers = function(element, options) {
    if (isNotEmptyElement(element)) {
        return true;
    }
    for (var i = 0, len = options.others.length; i < len; i++) {
        var other = options.others[i];
        var otherDom = other.nodeName ? other : (document.getElementById(other) || document.getElementById('form:' + other));
        if (isNotEmptyElement(otherDom)) {
            return true;
        }
    }

    return false;
};

ValidateFun.MandatoryWithOthers.message = VAL_AT_LEAST_ONE_FIELD_REQUIRED;

ValidateFun.MandatoryWhenOthersInput = function(element, options) {
    if (isNotEmptyElement(element)) {
        return true;
    }
   	var inputAnything = ValidateFun._isAnythingInputed(options.others);
    if (inputAnything) {
        if (!isNotEmptyElement(element)) {
            return false;
        }
    }
    return true;
};

ValidateFun.MandatoryWhenOthersInput.message = VAL_FIELD_REQUIRED_THIS_TIME;

//param: others, othersInput, ...
ValidateFun.MandatoryOneFieldWhenOthersInput = function(element, options) {
    if (isNotEmptyElement(element)) {
        return true;
    }
    var inputAnything = ValidateFun._isAnythingInputed(options.othersInput);
    if (inputAnything) {
		return ValidateFun.MandatoryWithOthers(element, options);
    }
    return true;
};

ValidateFun._isAnythingInputed = function(something){
	for (var i = 0, len = something.length; i < len; i++) {
        var sth = something[i];
        var sthDom = sth.nodeName ? sth : (document.getElementById(sth) || document.getElementById('form:' + sth));
        if (isNotEmptyElement(sthDom)) {
            return true;
        }
    }
    return false;
}

ValidateFun.MaxLength = function(element, options) {
    if (!element.value) {
        return true;
    }
    if(!options.isIgnoreLineFeed){
    	return !ValidateFun.isExceedMaxLengthWithLineFeed(element.value, options.limit || 480);
    }else{
    	return !ValidateFun.isExceedMaxLengthIgnoreLineFeed.call(this, element.value, options.limit || 480);
    }
};

ValidateFun.ValidateLengthIsEven = function(element){
	var value=trim(element.nodeName ? element.value : element);
	if(!value){
		return true;
	}
	return value.length%2==0;
};

ValidateFun.isExceedMaxLengthWithLineFeed = function(value, maxLimit) {
	var matchArr = jQuery.browser.msie ? null : value.match(/(\r)?\n/g);
	var matchTimes = (matchArr) ? matchArr.length : 0;
	return ((value.length + matchTimes) > maxLimit);
}

ValidateFun.isExceedMaxLengthIgnoreLineFeed = function(value, maxLimit) {
    if (!value) {
        return false;
    }
    return value.replace(/\r\n|\n/g,"").length > maxLimit;
};
ValidateFun.MaxLength.message = VAL_EXCEED_MAX_CHARACTERS;

ValidateFun.MinLength = function(element, options) {
	if (!element.value) {
        return true;
    }
	var value = element.value;
	if (value && options.trimValue) {
		value = element.value = $.trim(value);
	}
    if(!options.isIgnoreLineFeed){
    	return element.value.length >= (options.limit || 0);
    }
	return !ValidateFun.isUnderMinLengthIgnoreLineFeed.call(this, element.value, options.limit || 0);
};

ValidateFun.isUnderMinLengthIgnoreLineFeed = function(value, minLimit) {
	if (!value) {
        return true;
    }
    return value.replace(/\r\n|\n/g,"").length < minLimit;
};
ValidateFun.MaxLength.message = VAL_EXCEED_MAX_CHARACTERS;

ValidateFun.Digit = function(element,options) {
    var value = element.value;
	if (value && options.trimValue) {
        value = $.trim(value);
    }
    if (!value || value === "") {
        return true;
    }
    return new RegExp("^\\d+$").test(value);
};

ValidateFun.Digit.message = VAL_ONLY_DIGI_REQUIRED;

ValidateFun.EmailExpression = "^[a-zA-Z0-9_\'\\-]+(\\.[a-zA-Z0-9_\'\\-]+)*@[a-zA-Z0-9_\'\\-]+(\\.[a-zA-Z0-9_\'\\-]+)*[\\.][a-zA-Z]{2,6}([\\.][a-zA-Z]{2})?$";

ValidateFun.EmailAddress = function(element) {
    var value = $.trim(element.value);
    if (!value || value === "") {
        return true;
    }
    return new RegExp(ValidateFun.EmailExpression).test(value);
};

ValidateFun.EmailAddress.message = VAL_EMAIL_ADDRESS_FORMAT_ERROR;

ValidateFun.EmailAddresses = function(element) {
    var value = $.trim(element.value);
    var delimiter = $.trim(element.delimiter);
    if (!value || value === "") {
        return true;
    }
    if(delimiter == ""){
    	delimiter = " ";
    }
    var values = value.split(delimiter);
    for(var i=0; i<values.length; i++){
    	if(trim(values[i]) != "" && !new RegExp(ValidateFun.EmailExpression).test(values[i])){
    		return false;
    	}
    }
    return true;
};

ValidateFun.EmailAddresses.message = VAL_EMAIL_ADDRESSES_FORMAT_ERROR;

ValidateFun.Integer = function(element, options) {
    var value = element.value;
    if (value && options.trimValue) {
        value = element.value = $.trim(value);
    }
    if (!value || value === "") {
        return true;
    }
    if (options.defaultRemoveZero || options.allowZero) {
        if (new RegExp("^-?[0-9]\\d*$").test(value)) {
            if (parseInt(value, 10) === 0) {
			if (options.removePrefixZero) {
				value = element.value = "0";
			}
			if (options.defaultRemoveZero) {
				value = element.value = "";
			}
			return true;
            }
        }
        else {
            return false;
        }
    }
    else {
        if (!new RegExp("^-?[1-9]\\d*$").test(value)) {
            return false;
        }
    }

    var integer = parseInt(value, 10);
    var result = (options.min == null || integer >= options.min) && (options.max==null || integer <= options.max);
    if (result && options.removePrefixZero) {
        element.value = removePrefixZero(element.value, false);
    }
    return result;
};

ValidateFun.Integer.message = VAL_INTEGER_ONLY;

ValidateFun.MandatoryWithAnyChildInput = function(element) {
    var inputs = element.getElementsByTagName("input");
    for (var i = 0, len = inputs.length; i < len; i++) {
        if (inputs[i].value.length > 0) {
            return true;
        }
    }
    return inputs.length === 0;
}

ValidateFun.MandatoryWithAnyChildInput.message = VAL_AREA_MANDATORY;

ValidateFun.Regex = function(element, options) {
    var value = element.value;
    if (value && options.trimValue) {
        value = element.value = $.trim(value);
    }

    if (!value || value === "") {
        return true;
    }

    if (!new RegExp(options.regex).test(value)) {
        return false;
    }
    return true;
}

ValidateFun.LetterNumberCharsAndUnderline = function(element, options) {
	var value = element.nodeName ? element.value : element;
	if (value && options.trimValue) {
		value = element.value = $.trim(value);
	}
	var regex = new RegExp("[^a-zA-Z0-9_]");
	return !regex.test(value);
};

ValidateFun.LetterNumberCharsAndUnderline.message = VAL_ONLY_LETTERS_NUMBERS_AND_UNDERCORE;

ValidateFun.CompareFloatValueLessThan = function(element, options){
    var value = element.value;
    if (value && options.trimValue) {
        value = element.value = $.trim(value);
    }
    
    if(parseFloat(value) > options.compareToValue){
        return false;
    }

    return true;
}

ValidateFun.CompareIntValueLessThan = function(element, options){
	var value = element.value;
	if (value && options.trimValue) {
		value = element.value = $.trim(value);
	}
	
	if(parseInt(value) > options.compareToValue){
		return false;
	}
	
	return true;
}


ValidateFun.Float = function(element, options) {
    var value = element.value;
    if (value && options.trimValue) {
        value = element.value = $.trim(value);
    }
    if (!value || value === "") {
        return true;
    }
    if (!options.allowNegative && !new RegExp("^\\d+\\.?\\d*$").test(value)) {
        return false;
    }
    if (options.allowNegative && !new RegExp("^-?\\d+\\.?\\d*$").test(value)) {
        return false;
    }
    if (parseFloat(value) === 0) {
        if (options.defaultRemoveZero) {
            value = element.value = "";
        } else if (options.allowZero) {
        	if (options.removePrefixZero) {
        		value = element.value = "0";
            }
        }
        else {
            return false;
        }
    }

    var integralPartLength = 0;
    var ractionalPartLength = 0;
    if (value.indexOf('.') >= 0) {
        var numberParts = value.split('.');
        if (numberParts.length == 2) {
            integralPartLength = numberParts[0].length;
            ractionalPartLength = numberParts[1].length;
            if (ractionalPartLength === 0 && options.removeRedundantPoint) {
                element.value = value.substring(0, value.length - 1);
            }
        }
        else {
            integralPartLength = numberParts[0].length;
        }
    }
    else {
        integralPartLength = value.length;
    }
    var result = (!options.integralPartLimit || integralPartLength <= options.integralPartLimit) &&
                 (!options.fractionalPartLimit || ractionalPartLength <= options.fractionalPartLimit);
    if (result && options.removePrefixZero) {
        if (options.allowZero) {
            element.value = removePrefixZero(element.value, true);
        } else {
            element.value = removePrefixZero(element.value, false);
        }
    }
    return result;
}

ValidateFun.Float.message = VAL_FLOAT_ONLY;

function removePrefixZero(number, isKeepOneZero) {
    var removePrefixZeror = $.trim(number).replace(/^(0)+/, "");
    if (removePrefixZeror.indexOf('.') == 0) {
        return "0" + removePrefixZeror;
    } else {
        if (isKeepOneZero && removePrefixZeror === "") {
             return 0;
        }
    }
    return removePrefixZeror;
}

ValidateFun.Date = function(element) {
    var value = element.value;
    if (!value || value === "") {
        return true;
    }

    var date = Date.parse(value);
    if (isNaN(date)) {
        return false;
    }

    var jqueryElement = $(element);
    var mindate = jqueryElement.attr("mindate");
    var maxdate = jqueryElement.attr("maxdate");

    return (!mindate || date >= mindate) &&
           (!maxdate || date <= maxdate);
}

ValidateFun.Date.message = VAL_DATE_FORMAT_ERROR_OR_OUT_OF_RANGE;

var CommonValidator = function() {
    this.validationRules = [];
}

CommonValidator.prototype.addValidation = function() {
    for (i = 0; i < arguments.length; i++) {
        this.doAddValidation(arguments[i]);
    }
};

CommonValidator.prototype.clear = function() {
    this.validationRules = [];
};

CommonValidator.prototype.validate = function() {
    var result = true;
    for (var i = 0; i < this.validationRules.length; i++) {
        if (!this.validationRules[i]()) {
            result = false;
        }
    }
    return result;
};

CommonValidator.prototype.doAddValidation = function(validation) {
    for (var i = 0; i < this.validationRules.length; i++) {
        if (this.validationRules[i] === validation) {
            return;
        }
    }
    this.validationRules.push(validation);
};

var commonValidator = new CommonValidator();

//jquery.validate wrapper
(function($){
	$.fn.extend({
        validationElement: function(settings){
            return this.each(function(){
                this.validationElement = new Validation(this, settings);
            });  
		},
        addValidation: function(validationFunction,settings){
            var config = {
                level: Validation.Level.Self
            };
            if (settings) 
                $.extend(config, settings);
            return this.each(function(){
                this.validationElement.add(validationFunction, config);
            }); 
		},
        resetValidationElement: function(){
            return this.each(function(){
                this.validationElement.reset();
            }); 
		},
		validate:function(level){
			return this.each(function(){
                this.validationElement.validate(level);
            });
		}
    });
})(jQuery);

function replacePlaceholderByMsg(originMsg, msgValueList) {
  var result = originMsg;
  if(typeof(originMsg) == "undefined" || originMsg == null) {
	  return "";
  }
  if(msgValueList && msgValueList.constructor == Array) {
    for(var i = 0; i < msgValueList.length; i++) {
	 result = result.replace("{" + i + "}", msgValueList[i]);
    }
  }
  return result;
}

String.prototype.getUTF8BytesLength = function() {
  var totalLength = 0;
  var charCode;
  for (var i = 0; i < this.length; i++) {
    charCode = this.charCodeAt(i);
    if (charCode < 0x007f) {
      totalLength += 1;
    } else if ((0x0080 <= charCode) && (charCode <= 0x07ff)) {
      totalLength += 2;
    } else if ((0x0800 <= charCode) && (charCode <= 0xffff)) {
      totalLength += 3;
    }
  }
  return totalLength;
}