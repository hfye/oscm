drop table CategoryHistory;
drop table CategoryToCatalogEntryHistory;
drop table ModifiedEntityHistory;
drop table ModifiedUdaHistory;
drop table OperationParameterHistory;
drop table ParameterSetHistory;
drop table ProductReviewHistory;
drop table ProductReferenceHistory;
drop table MarketplaceToOrganizationHistory;
drop table MarketingPermissionHistory;
drop table ProductToPaymentTypeHistory;
drop table TechnicalProductOperationHistory;
drop table SupportedLanguageHistory;
drop table OrganizationToCountryHistory;
drop table RoleAssignmentHistory;
drop table OnBehalfUserReferenceHistory;
drop table TriggerDefinitionHistory;
drop table TriggerProcessHistory;
<<<<<<< e28c8ddae7949b373263783b6a1efec888c405c4
drop table PaymentResultHistory;

delete from hibernate_sequences where sequence_name = 'CategoryHistory';
delete from hibernate_sequences where sequence_name = 'CategoryToCatalogEntryHistory';
delete from hibernate_sequences where sequence_name = 'ModifiedEntityHistory';
delete from hibernate_sequences where sequence_name = 'ModifiedUdaHistory';
delete from hibernate_sequences where sequence_name = 'OperationParameterHistory';
delete from hibernate_sequences where sequence_name = 'ParameterSetHistory';
delete from hibernate_sequences where sequence_name = 'ProductReviewHistory';
delete from hibernate_sequences where sequence_name = 'ProductReferenceHistory';
delete from hibernate_sequences where sequence_name = 'MarketplaceToOrganizationHistory';
delete from hibernate_sequences where sequence_name = 'MarketingPermissionHistory';
delete from hibernate_sequences where sequence_name = 'ProductToPaymentTypeHistory';
delete from hibernate_sequences where sequence_name = 'TechnicalProductOperationHistory';
delete from hibernate_sequences where sequence_name = 'SupportedLanguageHistory';
delete from hibernate_sequences where sequence_name = 'OrganizationToCountryHistory';
delete from hibernate_sequences where sequence_name = 'RoleAssignmentHistory';
delete from hibernate_sequences where sequence_name = 'OnBehalfUserReferenceHistory';
delete from hibernate_sequences where sequence_name = 'TriggerDefinitionHistory';
delete from hibernate_sequences where sequence_name = 'TriggerProcessHistory';
delete from hibernate_sequences where sequence_name = 'PaymentResultHistory';
=======
drop table PaymentResultHistory;
>>>>>>> deleted 19 history tables and adapted tests - Suzana[10,0,0]
