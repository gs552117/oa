Ext.define('oa.view.department.DepartmentPicker', {
    extend: 'Ext.ux.TreePicker',

    alias: 'widget.departmentPicker',

    autoScroll: true,
    rootVisible: false,

    fieldLabel: '所属部门',
    name: 'departmentIds',
    displayField: 'text',
    anchor: '90%',
    emptyText: '请选择...',

    store: Ext.create('Ext.data.TreeStore', {
        fields: [{
            name: 'text',
            mapping: 'name'
        }],

        root: {
            id: 1,
            text: '所有部门',
            expanded: true
        },

        autoLoad: true,
        proxy: {

            type: 'ajax',
            url: oa.config.Config.BASE_URL + 'department/list',
            reader: {
                type: 'json',
                rootProperty: 'data'
            }
        }
    }),

    initComponent: function () {
        this.callParent(arguments);
    }

});