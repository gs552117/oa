Ext.define('oa.view.plan.PlanMoneyInMonthController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.planMoneyInMonth',
    requires: ['oa.config.Config'],

    store: ['planMoneyInMonth'],


    init: function () {
    },

    addPlanMoneyInMonth: function (sender) {
        var info = Ext.getCmp('planMoneyInMonthInfo');
        if (info == null) {
            info = Ext.create('planMoneyInMonthInfo');
        }
        info.show();
    },

    viewPlanMoneyInMonth: function(sender) {
        var gird = sender.up('planMoneyInMonthList');
        var record = gird.getSelectionModel().getSelection()[0];

        var info = Ext.getCmp('planMoneyInMonthInfo');
        if (info == null) {
            info = Ext.create('planMoneyInMonthInfo');
        }
        info.down('form').loadRecord(record);
        info.show();
    },

    deletePlanMoneyInMonth: function (sender) {
        var gird = sender.up('planMoneyInMonthList');
        var record = gird.getSelectionModel().getSelection()[0];

        Ext.MessageBox.confirm("删除计划", "您确认要删除计划？", function (btn) {
            if (btn == 'yes') {
                Ext.Ajax.request({
                    url: oa.config.Config.BASE_URL + '/plan/money/in/month/delete',
                    method: 'POST',
                    params: {
                        id: record.data.id
                    },
                    success: function (response, opts) {
                        gird.store.remove(record);
                    },

                    failure: function (response, opts) {
                        Ext.Msg.alert('Failed', action.result.msg);
                    }
                });
            }
        });
    },

    updatePlanMoneyInMonth: function (sender) {
        var form = sender.up('form').getForm();
        if (form.isValid()) {
            form.submit({
                success: function(form, action) {
                    var data = action.result.data;

                    var planList = Ext.getCmp('planMoneyInMonthList');
                    var store = planList.store;
                    var record = store.getById(data.id);
                    if (record != null) {
                        record.data = data;
                    } else {
                        store.add(data);
                    }

                    // refresh grid view
                    planList.getView().refresh();
                    // window close
                    sender.up("window").close();
                },
                failure: function(form, action) {
                    Ext.Msg.alert('Failed', action.result.msg);
                }
            })
        }
    }
});