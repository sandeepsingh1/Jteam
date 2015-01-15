package com.hannover.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.hannover.form.HannoverMotorForm;

public class HannoverMotorAction extends DispatchAction {
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HannoverMotorForm hannoverMotorForm = (HannoverMotorForm) form;
		return mapping.findForward("success");
	}
	

}
